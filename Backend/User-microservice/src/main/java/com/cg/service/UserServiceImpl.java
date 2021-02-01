package com.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.User;
import com.cg.dao.UserDao;
import com.cg.exception.NoValueFoundException;

import com.cg.exception.NotPossibleException;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserDao userDao;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/***
	 * This Function is used to add User
	 */
	@Override
	public User addUser(User user) {
		user.setRole("user");
		String tempUsername;
		tempUsername = user.getUserName();
		User user1 = userDao.findByUserName(tempUsername);
		if (tempUsername != null) {
			if (user1 != null)
				throw new NoValueFoundException("Username already exists");
			return userDao.save(user);
		} else
			return null;

	}

	/***
	 * This function is used to delete user
	 */
	@Override
	public void deleteUser(Long userId) {
		User user = this.userDao.findAll().stream().filter(x -> userId.equals(x.getUserId())).findAny().orElse(null);
		if (user == null) {
			logger.warn("check the userId is correct or not");
			throw new NotPossibleException("Given ID is not present so User Deletion operation is not possible...");
		} else
			this.userDao.deleteById(userId);

	}

	/***
	 * This Function is used to search the user
	 */
	@Override
	public User searchUser(Long userId) {

		return userDao.findById(userId).orElseThrow(() -> new NoValueFoundException("User ID Not Found"));
	}

	/***
	 * This Function is used to update the user
	 */
	@Override
	public User updateUser(User user) {
		System.out.println(user.getUserId());
		if (this.searchUser(user.getUserId()) == null)
			throw new NotPossibleException("Cannot update this user...");
		return this.userDao.save(user);
	}

	/***
	 * This function is used to get all user
	 */
	@Override
	public List<User> getAllUser() {
		if (this.userDao.findAll() == null) {
			logger.warn("Check if database is empty or not");
			throw new NoValueFoundException("There is no user in Table...");
		}
		return this.userDao.findAll();
	}

	@Override
	public long countUser() {

		return this.userDao.count();
	}
	
	@Override
	public int checkEmail(User user) {
		// TODO Auto-generated method stub
		String tempEmail=user.getEmail();
		User user1=userDao.findByEmail(tempEmail);
		if(user1!=null)
			throw new NotPossibleException("EmailId already registered");
		else
			return 0;
	}
	

	@Override
	public int checkMobileNo(User user) {
		// TODO Auto-generated method stub
		String tempNo=user.getMobileNo();
		User user1=userDao.findByMobileNo(tempNo);
		if(user1!=null)
			throw new NotPossibleException("MobileNo already registered");
		else
			return 0;
	}

}

package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Login;
import com.cg.bean.User;
import com.cg.dao.UserDao;
import com.cg.exception.NotFoundException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByUserName(String userName) {
		return userDao.findByUserName(userName);

	}

	@Override
	public User getUserByUserNameAndPassword(String tempUsername, String tempPassword) {
		return userDao.findByUserNameAndPassword(tempUsername, tempPassword);
	}

	@Override
	public User loginUser(Login user) throws NotFoundException {

		String tempUsername = user.getUserName();
		String tempPassword = user.getPassword();
		User userObj;
		User userObj1;

		if (tempUsername != null && tempUsername != "" && tempPassword != null) {

			userObj1 = this.getUserByUserName(tempUsername);
			if (userObj1 == null)
				throw new NotFoundException("Username ", "Does not exist! Registration required!");

			userObj = this.getUserByUserNameAndPassword(tempUsername, tempPassword);
			if (userObj == null)
				throw new NotFoundException("Password", "Invalid password");

			return userObj;
		} else
			throw new NotFoundException("Username/Password", "Cannot be null !");

	}


	@Override
	public User addUser(User user) {
		user.setRole("user");	
		String tempUsername;
		tempUsername=user.getUserName();
		User user1=this.getUserByUserName(tempUsername);
		if(tempUsername!=null) {
			if(user1 != null)
			throw new NotFoundException("Username", "already exist !");
			return userDao.save(user);
		}	
		else 
			return null;
		
	
	}

	@Override
	public int checkEmail(User user) {
		// TODO Auto-generated method stub
		String tempEmail=user.getEmail();
		User user1=userDao.findByEmail(tempEmail);
		if(user1!=null)
			throw new NotFoundException("EmailId", " Found");
		else
			return 0;
	}
	

	@Override
	public int checkMobileNo(User user) {
		// TODO Auto-generated method stub
		String tempNo=user.getMobileNo();
		User user1=userDao.findByMobileNo(tempNo);
		if(user1!=null)
			throw new NotFoundException("MobileNo", " Found");
		else
			return 0;
	}

	@Override
	public long checkUserName(String userName) {
		// TODO Auto-generated method stub
		User user=this.getUserByUserName(userName);
		if(user!=null)
			return user.getUserId();
		else
			throw new NotFoundException("Username", " Found");
			
		
	}

	@Override
	public long checkSecurityAnswer(long id, String answer) {
		User user=userDao.findByUserId(id);
		if(user.getSecurityAnswer().equals(answer))
			return user.getUserId();
		else
			throw new NotFoundException("Answer", " Invalid");
			
		
	}

	@Override
	public long resetPassword(long id, String newPassword) {
		// TODO Auto-generated method stub
		User user=userDao.findById(id).orElseThrow(() -> new NotFoundException("User ID", "Not Found"));
		user.setPassword(newPassword);
		userDao.save(user);
		
		return user.getUserId();
	}

	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElseThrow(() -> new NotFoundException("User ID", "Not Found"));
		 
	}


}

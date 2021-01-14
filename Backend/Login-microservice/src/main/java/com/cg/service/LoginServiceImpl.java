package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Login;
import com.cg.bean.User;
import com.cg.dao.UserDao;
import com.cg.exception.NotFoundException;



@Service
public class LoginServiceImpl implements LoginService {

	// The process of injection spring bean dependencies while initializing it
	@Autowired
	private UserDao userDao;


	@Override
	public User getUserByUserName(String userName) {
		return userDao.findByUserName(userName);
		 
	}

	@Override
	public User addUser(User user) {
		user.setRole("user");
		String tempUsername;
		tempUsername=user.getUserName();
		if(tempUsername!=null && !"".equals(tempUsername))
			throw new NotFoundException("Username", "already exist !");
		return userDao.save(user);
	}

	@Override
	public User getUserByUserNameAndPassword(String tempUsername, String tempPassword) {
		return userDao.findByUserNameAndPassword(tempUsername,tempPassword);
	}

	@Override
	public User loginUser(Login user) throws NotFoundException {
		// TODO Auto-generated method stub
		String tempUsername = user.getUserName();
		String tempPassword = user.getPassword();
		User userObj ;
		User userObj1;
		
		if (tempUsername != null && tempUsername!="" && tempPassword != null) {
			
			userObj1=this.getUserByUserName(tempUsername);
			if(userObj1==null)
				throw new NotFoundException("Username ","Does not exist! Registration required!");
			
				
			userObj = this.getUserByUserNameAndPassword(tempUsername, tempPassword);
			if(userObj==null)
				throw new NotFoundException("Password","Invalid password");
			
			return userObj ;
		}
		else throw new NotFoundException("Username/Password","Cannot be null !");
			

	}

	
}

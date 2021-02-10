package com.cg.service;

import com.cg.bean.Login;
import com.cg.bean.User;

public interface LoginService {

	public User getUserByUserName(String userName);

	public User getUserByUserNameAndPassword(String tempUsername, String tempPassword);

	public User loginUser(Login user);
	
	public User addUser(User user);

	public int checkEmail(User user);

	public int checkMobileNo(User user);

	public long checkUserName(String userName);

	public long checkSecurityAnswer(long id, String answer);

	public long resetPassword(long id, String newPassword);

	public User findUserById(long id);



}

package com.cg.service;

import com.cg.bean.Login;
import com.cg.bean.User;

public interface LoginService {

	public User getUserByUserName(String userName);

	public User getUserByUserNameAndPassword(String tempUsername, String tempPassword);

	public User loginUser(Login user);

}

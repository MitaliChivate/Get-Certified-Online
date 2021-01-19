package com.cg.service;

import java.util.List;

import com.cg.beans.User;

public interface UserServiceInterface {

	public User addUser(User user);

	public void deleteUser(Long userId);

	public User searchUser(Long userId);

	public List<User> getAllUser();

	public User updateUser(User user);

}

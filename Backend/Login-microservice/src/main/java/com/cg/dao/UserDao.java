package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	User findByUserNameAndPassword(String tempUsername, String tempPassword);
	
	User findByEmail(String email);
	
	User findByMobileNo(String mobileNo);
	
	User findByUserId(long id);

}

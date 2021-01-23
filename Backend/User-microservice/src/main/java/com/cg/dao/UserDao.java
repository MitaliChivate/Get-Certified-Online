package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

}

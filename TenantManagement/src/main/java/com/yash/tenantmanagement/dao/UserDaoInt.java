package com.yash.tenantmanagement.dao;

import java.util.List;

import com.yash.tenantmanagement.domain.User;
import com.yash.tenantmanagement.dto.LoginDto;

public interface UserDaoInt {

	public void saveUser(User user);
	
	User getUserByEmail(String email);
	
	public void updateUser(User user);
	
	public void deleteUser(Long id);
	
	User getUserById(Long id);
	
	List<User> getAllUsers(int page,int size,String sort);
	
	List<User> searchUser(String username,String address);
}

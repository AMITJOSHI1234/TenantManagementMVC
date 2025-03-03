package com.yash.tenantmanagement.service;

import java.util.List;

import com.yash.tenantmanagement.domain.User;
import com.yash.tenantmanagement.dto.LoginDto;
import com.yash.tenantmanagement.dto.UserDto;

public interface UserServiceInt {

	void registerUser(UserDto user);
	
	User getUserByEmail(String email);
	
	User authenticateUser(LoginDto login);
	
	public void updateUser(UserDto user);
	
	public void deleteUser(Long id);
	
	public UserDto getUserById(Long id);
	
	public List<UserDto> getAllUsers(int page,int size,String sort);
	
	List<UserDto> searchUser(String username,String address);
}


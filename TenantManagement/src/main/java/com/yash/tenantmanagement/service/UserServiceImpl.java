package com.yash.tenantmanagement.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.tenantmanagement.dao.UserDaoInt;
import com.yash.tenantmanagement.domain.User;
import com.yash.tenantmanagement.dto.LoginDto;
import com.yash.tenantmanagement.dto.UserDto;

/**
* This is a UserService handeling buisness logic and transaction 
* @author amit joshi
*/
@Service
@Transactional
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDaoInt userDao;
	
	@Override
	@Transactional(readOnly = false)
	public void registerUser(UserDto userdto) {
		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setAddress(userdto.getAddress());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setPhone(userdto.getPhone());
		user.setRole(2L);
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public User authenticateUser(LoginDto login) {
		User user = getUserByEmail(login.getEmail());
		if(user==null && user.getPassword().equals(login.getPassword())) {
			return user;
		}
		
		return null;
	}

	@Override
	public void updateUser(UserDto userDto) {
		System.out.println("UserId:"+userDto.getUserId());
        User user = this.userDao.getUserById(userDto.getUserId());
        if(user!=null) {
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        
        this.userDao.updateUser(user);
        }
	}

	@Override
	public void deleteUser(Long id) {
	this.userDao.deleteUser(id);
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = this.userDao.getUserById(id);
		UserDto dto = new UserDto();
		dto.setUserId(user.getUserId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setAddress(user.getAddress());
		
		return dto;
	}

	@Override
	public List<UserDto> getAllUsers(int page,int size,String sort) {
		List<User> users = this.userDao.getAllUsers(page,size,sort);
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(User user:users) {
			UserDto userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
			userDto.setEmail(user.getEmail());
			userDto.setPhone(user.getPhone());
			userDto.setAddress(user.getAddress());
			userDtos.add(userDto);
		}
		return userDtos;
	}

	@Override
	public List<UserDto> searchUser(String username, String address) {
		List<User> users = this.userDao.searchUser(username, address);
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(User user:users) {
			UserDto userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUsername(user.getUsername());
	        userDto.setPassword(user.getPassword());
	        userDto.setEmail(user.getEmail());
	        userDto.setPhone(user.getPhone());
	        userDto.setAddress(user.getAddress());
	        userDtos.add(userDto);
		}
		
		return userDtos;
	}

}

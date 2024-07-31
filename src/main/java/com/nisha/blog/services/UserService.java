package com.nisha.blog.services;

import java.util.List;

import com.nisha.blog.entities.User;
import com.nisha.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
    UserDto updateUser(UserDto user, Integer userId);
    
    UserDto getUserById(Integer userId);
    
    List<UserDto> getAllUsers();
    
    void deleteUser(Integer userId);
    
}

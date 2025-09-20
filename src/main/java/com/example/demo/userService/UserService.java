package com.example.demo.userService;

import java.util.List;

import com.example.demo.model.UserModel;
import com.example.demo.userDto.UserDto;

public interface UserService {

	UserModel saveUser(UserDto userDto);
	
	List<UserDto> getAll();
	
	void deleteUser(long id);
	
	UserModel findById(long id);
	
}

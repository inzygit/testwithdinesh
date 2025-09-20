package com.example.demo.userServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.userDto.UserDto;
import com.example.demo.userRepositoryImpl.UserRepositoryImpl;
import com.example.demo.userService.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;

	@Override
	public UserModel saveUser(UserDto userDto) {
		UserModel userModel = new UserModel();
		userModel.setId(userDto.getId());
		userModel.setName(userDto.getName());

		return userRepositoryImpl.save(userModel);
	}

	@Override
	public List<UserDto> getAll() {
		
		return userRepositoryImpl.findAll().stream()
				.sorted((firstdata,seconddata)-> Long.compare(firstdata.getId(), seconddata.getId()))
				.map(this:: generateCourse)
				.collect(Collectors.toList());
	}

	private UserDto generateCourse(UserModel userModel) {
		UserDto userDto = new UserDto();
		userDto.setId(userModel.getId());
		userDto.setName(userModel.getName());
		return userDto;

	}

	@Override
	public void deleteUser(long id) {
		userRepositoryImpl.deleteById(id);
	}

	
}
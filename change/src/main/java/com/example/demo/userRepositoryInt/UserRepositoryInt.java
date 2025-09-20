package com.example.demo.userRepositoryInt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserModel;

public interface UserRepositoryInt extends JpaRepository<UserModel, Long> {
	
	

}

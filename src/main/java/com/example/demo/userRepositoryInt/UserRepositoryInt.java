package com.example.demo.userRepositoryInt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserModel;

public interface UserRepositoryInt extends JpaRepository<UserModel, Long>{
	
	UserModel getUserById(Long id);
}

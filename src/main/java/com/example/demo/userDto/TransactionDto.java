package com.example.demo.userDto;

import lombok.Data;

@Data
public class TransactionDto {
	
	public Long id;
	private Integer amount;
	private String name;
	private Integer test;
}

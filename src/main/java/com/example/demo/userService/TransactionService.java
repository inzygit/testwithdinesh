package com.example.demo.userService;

import java.util.List;
import com.example.demo.model.Transaction;
import com.example.demo.userDto.TransactionDto;

public interface TransactionService {
	
	Transaction saveTransaction(TransactionDto transactionDto);
	
	List<TransactionDto> getAll();
	
	void deleteTransaction(long id);
	
	Transaction getById(Long id);
	
 }

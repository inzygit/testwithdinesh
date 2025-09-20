package com.example.demo.userController.many_to_one;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Transaction;
import com.example.demo.userDto.TransactionDto;
import com.example.demo.userService.TransactionService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TransactionController {
	
	@Autowired
	public TransactionService transactionService;
	
	@PostMapping("/save/transaction")
	public Transaction saveTransaction(@RequestBody TransactionDto transactionDto) {
		return transactionService.saveTransaction(transactionDto);
	}
	
	@GetMapping("/get/transaction")
	public List<TransactionDto> getAllTransaction(){
		return transactionService.getAll();		
	}
	
	@DeleteMapping("/delete/transaction/{id}")
	public void deleteTransaction(@PathVariable Long id) {
		transactionService.deleteTransaction(id);
	}
	
	@GetMapping("/getTransaction/{id}")
	public Transaction getByTransactionId(@PathVariable Long id) {
		return transactionService.getById(id);
	}

}

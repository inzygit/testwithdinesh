package com.example.demo.userServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.userDto.TransactionDto;
import com.example.demo.userRepositoryImpl.TransactionRepositoryImpl;
import com.example.demo.userService.TransactionService;

@Service
public  class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepositoryImpl transactionRepositoryImpl;

//	@Autowired
//	private ModelMapper modelMapper;
	
	@Override
	public Transaction saveTransaction(TransactionDto transactionDto) {
		Transaction transaction = new Transaction();
		transaction.setId(transactionDto.getId());
		transaction.setName(transactionDto.getName());
		transaction.setAmount(transactionDto.getAmount());
		transaction.setTest(transactionDto.getTest());
		return transactionRepositoryImpl.save(transaction);
//		Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
//		return transactionRepositoryImpl.save(transaction);
	}	

	@Override
	public List<TransactionDto> getAll() {
		return transactionRepositoryImpl.findAll().stream()
				.map(this:: generateTransaction)
				.collect(Collectors.toList());
	}
	
	public TransactionDto generateTransaction(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		
		transactionDto.setId(transaction.getId());
		transactionDto.setAmount(transaction.getAmount());
		transactionDto.setName(transaction.getName());
		transactionDto.setTest(transaction.getTest());
		return transactionDto;
	}
	
//	@Transactional
//    public void performTransaction() {
//        // Do some database operations
//        Transaction transaction = new Transaction();
//        transaction.setName("Test Name");
//        transactionRepositoryImpl.save(transaction);
//
//        // Simulate an exception to trigger a rollback
//        if (true) {
//            throw new RuntimeException("Something went wrong!");
//        }
//    }
	
	@Override
	public void deleteTransaction(long id) {
		transactionRepositoryImpl.deleteById(id);
	}

	@Override
	public Transaction getById(Long id) {
		return transactionRepositoryImpl.findDataById(id);
	}
}

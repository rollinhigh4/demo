package com.banking.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.model.Customers;
import com.banking.demo.repository.BankingRepository;

@Service
public class BankingService {

	@Autowired
	BankingRepository bankingRepository;

	public Double getBalanceById(String id) {
		return bankingRepository.findById(id).get().getBalance();
	}

	public Double withdrawal(String id, Double amount) {
		Customers customer = bankingRepository.findById(id).get();
		Double balance = customer.getBalance();
		balance = balance - amount;
		customer.setBalance(balance);
		bankingRepository.save(customer);
		return balance;
	}

	public Double deposit(String id, Double amount) {
		Customers customer = bankingRepository.findById(id).get();
		Double balance = customer.getBalance();
		balance = balance + amount;
		customer.setBalance(balance);
		bankingRepository.save(customer);
		return balance;
	}

	public void save(Customers customer) {
		bankingRepository.save(customer);
	}

	public List<Customers> findAllCustomer() {

		return bankingRepository.findAll();
	}

	public Customers send(String id1, String id2, Double amount) {
		Customers customer1 = bankingRepository.findById(id1).get();
		Customers customer2 = bankingRepository.findById(id2).get();
		Double balance1 = customer1.getBalance();
		customer1.setBalance(balance1 - amount);

		Double balance2 = customer2.getBalance();
		customer2.setBalance(balance2 + amount);

		bankingRepository.save(customer1);
		bankingRepository.save(customer2);

		return customer1;
	}
}

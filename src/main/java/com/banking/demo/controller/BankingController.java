package com.banking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.model.Customers;
import com.banking.demo.service.BankingService;

@RestController
public class BankingController {

	@Autowired
	BankingService bankingService;

	@GetMapping("/banking")
	public List<Customers> getAllCustomers() {
		return bankingService.findAllCustomer();
	}

	@PostMapping("/banking")
	public String addCustomer(@RequestBody Customers customer) {
		bankingService.save(customer);
		return customer.getId();
	}

	@GetMapping("/banking/{id}/balance")
	public Double getCustomerBalance(@PathVariable("id") String id) {
		return bankingService.getBalanceById(id);
	}

	@PostMapping("/banking/{id}/withdrawal/{amount}")
	public Double withdraw(@PathVariable("id") String id, @PathVariable("amount") Double amount) {

		return bankingService.withdrawal(id, amount);
	}

	@PostMapping("/banking/{id}/deposit/{amount}")
	public Double deposit(@PathVariable("id") String id, @PathVariable("amount") Double amount) {

		return bankingService.deposit(id, amount);
	}

	@PostMapping("/banking/transaction/{id1}/to/{id2}/{amount}")
	public Customers sendMoney(@PathVariable("id1") String id1, @PathVariable("id2") String id2,
			@PathVariable("amount") Double amount) {
		return bankingService.send(id1, id2, amount);
	}
}

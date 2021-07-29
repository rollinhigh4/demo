package com.banking.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.demo.model.Customers;

@Repository
public interface BankingRepository extends JpaRepository<Customers, String> {

	// public List<Customers> getAllCustomers();
}

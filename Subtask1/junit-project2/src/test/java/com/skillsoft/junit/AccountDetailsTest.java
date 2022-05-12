package com.skillsoft.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountDetailsTest {
	
	/* Testing with JUnit and using AfterEach & BeforeEach And BeforeAll & AfterAll */
	
	AccountDetails accountDetails;
	
	@BeforeAll
	static void initAll() {
		
		System.out.println("@BeforeAll block has been executed");
		System.out.println("Initilize all");
	}
	
	@BeforeEach
	void init() {
		accountDetails = new AccountDetails("Anita", 011401533, 11401533, 5000 , "Savings");
		
		System.out.println("@BeforeEach block has been executed");
		System.out.println("Account balance: " + accountDetails.getBalance());
	}
	
	@Test
	void depositeTest() {
		
		accountDetails.deposit(500);
		System.out.println("@Test block for deposit has been executed");
	}
	
	@Test
	void withdrawTest() {
		
		accountDetails.withdraw(1000);
		System.out.println("@Test block for withdraw has been executed");
	}
	
	@AfterEach
	void balance() {
		
		System.out.println("@AfterEach  has been executed");
		System.out.println("Account balance: " + accountDetails.getBalance());
	}
	
	@AfterAll
	static void teardownAll() {
		
		System.out.println("@AfterAll block has been executed");
		System.out.println("Clean all");
	}
}

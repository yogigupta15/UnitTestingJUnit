package com.skillsoft.junit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.skillsoft.junit.AccountDetails;

public class AccountDetailsTest {
	/* Testing with JUnit */
	AccountDetails accountDetails = new AccountDetails("Anita", 011401533, 11401533, 5000 , "Savings");
	
	@Test
	public void validateName() {
		
		assertTrue(accountDetails.getName().matches("^[a-zA-Z]*$"));
	}
	
	@Test
	public void validateBalance() {
		
		assertTrue(accountDetails.getBalance() >= 0);
	}
}

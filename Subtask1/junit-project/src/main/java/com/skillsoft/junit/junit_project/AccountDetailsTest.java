package com.skillsoft.junit.junit_project;

public class AccountDetailsTest {
	/* writing a test without JUnit */
	AccountDetails accountDetails = new AccountDetails("Ankita", 011401533, 11401533, 5000, "Savings");
	
	void validateName() {
		
		if(accountDetails.getName().matches("^[a-zA-Z]*$")) {
			
			System.out.println("Test passed : Name is valid");
			
		}else {
			
			System.out.println("Test failed : Name is invalid");
		}
	}
	
	public static void main(String[] args) {
		
		AccountDetailsTest accountDetailsTest = new AccountDetailsTest();
		accountDetailsTest.validateName();
	}
}

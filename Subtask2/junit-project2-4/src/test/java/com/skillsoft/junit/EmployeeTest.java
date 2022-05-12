package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.naming.NamingException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	/* Checking for Exceptions using JUnit */
	
	static Employee firstEmployee;
	
	@BeforeAll
	static void initEmployee() {

		firstEmployee = new Employee("Susan","4ester",1005,'F',"Tech Lead",80000,"Permanent");		
	}
	@Test
	void assertTest() {
		
		assertThrows(NamingException.class,
				() -> {firstEmployee.validateLastName();},
				"Throws Exception Test");
	}
}

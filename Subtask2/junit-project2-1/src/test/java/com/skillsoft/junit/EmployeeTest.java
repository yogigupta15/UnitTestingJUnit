package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	/* using the AssertEquals method */
	
	static Employee employee;
	
	@BeforeAll
	static void initEmployee() {
		
		employee = new Employee("Amy","Cruz",1001,'F',"Devloper",50000,"Permanent");
	}
	
	@Test
	void assertTest() {
		
		employee.adjustSalary(5000);
		assertEquals(55000,employee.getSalary());
	}
	
	@Test
	void assertTest1() {
		
		assertEquals("Alford", employee.getLastName(), "check last name");
	}
}

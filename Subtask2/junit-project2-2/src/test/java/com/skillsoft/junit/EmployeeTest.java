package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	/* using the Assert methods and their converse */
	
	static Employee firstEmployee;
	static Employee secondEmployee;
	
	@BeforeAll
	static void initEmployee() {
		
		firstEmployee = new Employee("Amy","Cruz",1001,'F',"Devloper",50000,"Permanent");
		secondEmployee = new Employee("Brian","Alford",1011,'M',"Devloper",45000,"Contract");
	}
	
	@Test
	void assertTest() {
		
		assertTrue(firstEmployee.getRole().equals(secondEmployee.getRole()), "Test that both employees have the same role");
	}
	
	@Test
	void assertTest1() {
		
		assertFalse(firstEmployee.getRole().equals(secondEmployee.getRole()), "Test that both employees have the same role");
	}
	
	@Test
	void assertTest2() {
		
		Employee firstShalowCopy = firstEmployee;
		Employee firstSeparateCopy = new Employee(firstEmployee.getFirstName(),firstEmployee.getLastName(),
				firstEmployee.getId(),firstEmployee.getGender(),
				firstEmployee.getRole(), firstEmployee.getSalary(),
				firstEmployee.getType());
		
		assertSame(firstEmployee, firstShalowCopy, "Test an object and a copy for sameness");
		assertSame(firstEmployee, firstSeparateCopy, "Test an object and a copy for sameness");
	}
	
	@Test
	void assertTest3() {
		
		Employee firstSeparateCopy = new Employee(firstEmployee.getFirstName(),firstEmployee.getLastName(),
				firstEmployee.getId(),firstEmployee.getGender(),
				firstEmployee.getRole(), firstEmployee.getSalary(),
				firstEmployee.getType());
		
		assertSame(firstEmployee.getRole(), firstSeparateCopy.getRole(), "Test two strings for sameness");
	}
	
	@Test
	void assertTest4() {
		
		Employee firstShalowCopy = firstEmployee;
		assertNotSame(firstEmployee, firstShalowCopy, "Test two objects for sameness");
	}
}

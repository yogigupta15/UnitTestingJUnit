package com.skillsoft.junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class EmployeeTest {
	
	/* Working with Different Parameter Source in JUnit */
	
	@ParameterizedTest
	@NullSource
	@DisplayName("Null Name Check")
	void nameTest(String name) {
		
		Employee employee = new Employee(name, name, 1011, 'M', "Tester", 50000, "Contract");
		
		assertNull(employee.getFirstName());
		assertNull(employee.getLastName());
	}
	
	@ParameterizedTest
	@EmptySource
	@DisplayName("Empty Name Check")
	void nameTest1(String name) {
		
		Employee employee = new Employee(name, name, 1011, 'M', "Tester", 50000, "Contract");
		
		assertEquals("", employee.getFirstName());
		assertEquals("", employee.getLastName());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("Null And Empty First Name Check")
	void nameTest2(String name) {
		
		Employee employee = new Employee(name, name, 1011, 'M', "Tester", 50000, "Contract");
		
		String fName = employee.getFirstName();
		assertTrue(fName == null || fName.isEmpty());
	}
	
	@ParameterizedTest
	@CsvSource({"Brain, Alford","Amy, Cruz", "Raj, Chawanda"})
	@DisplayName("Name Check")
	void nameTest3(String fName, String lName) {
		
		Employee employee = new Employee(fName.trim(), lName.trim(), 1011, 'M', "Tester", 50000, "Contract");
		
		assertEquals(fName.trim(), employee.getFirstName());
		assertEquals(lName.trim(), employee.getLastName());
	}
}
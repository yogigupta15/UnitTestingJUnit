package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.naming.InvalidNameException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EmployeeTest {
	
	/* Running Parameterized Tests with a valueSource in JUnit */
	
	@ParameterizedTest
	@DisplayName("Last Name Check")
	@ValueSource(strings = {"Al4d", "B3nson", "$mith", "@lford"})
	void nameTest(String lastName) {
		
		Employee employee = new Employee("Brain", lastName, 1011, 'M', "Tester", 50000, "Contract");
		
		assertThrows(InvalidNameException.class, 
				() -> {employee.validateLastName();},
				"Throws Exception test");
	}
}

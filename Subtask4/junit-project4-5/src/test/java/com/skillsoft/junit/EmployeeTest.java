package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class EmployeeTest {
	
	/* Working with Different Parameter Source in JUnit and using the CSV file fetching the name of Employee  */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/empnames.csv", numLinesToSkip = 1)
	@DisplayName("Name Check")
	void NameTest(String FName, String lName) {
		
		Employee employee = new Employee(FName.trim(), lName.trim(), 1011, 'M', "Tester", 50000, "Contract");
		
		assertEquals(FName.trim(), employee.getFirstName());
		assertEquals(lName.trim(), employee.getLastName());
	}
}
package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

public class EmployeeTest {
	
	@ParameterizedTest
	@ValueSource(strings = {"developer", "tester", "release engineer", "storege engineer"})
	@DisplayName("Role Check")
	void converterTest(@ConvertWith(RoleConverter.class) String role) {
		
		Employee employee = new Employee("Brain", "Alford", 1011, 'M', role, 50000, "Contract");
		
		System.out.println("Value of role: " + role);
		assertEquals(role, employee.getRole());
	}
}
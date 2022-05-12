package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class EmployeeTest {
	/* Running Tests Repeatedly in JUnit */
	static Employee employee;
	static double salary;
	
	@BeforeAll
	static void initEmployee() {
		
		salary = 45000;
		employee = new Employee("Brain", "Alford", 1011, 'M', "Tester", salary, "Contract");
	}
	
	@RepeatedTest(5)
	@DisplayName("Salary Update")
	void salaryUpdateTest() {
		
		double salaryIncrement = 2000.0;
		employee.adjustSalary(salaryIncrement);
		salary += salaryIncrement;
		
		assertEquals(salary, employee.getSalary(), "Test salary updates");
	}
}

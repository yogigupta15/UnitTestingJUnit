package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	/* Using Assumption in Test Cases in JUnit */
	
	static Employee employee;
	static GregorianCalendar gc;
	
	@BeforeAll
	static void initEmployee() {
		
		employee = new Employee("Susan", "Forrester", 1005, 'F',"Tech Lead", 80000, "Permanent");
		gc = new GregorianCalendar();
	}
	
	@Test
	void assumptionTest() {
		
		System.out.println("Current hour: " + gc.get(Calendar.HOUR_OF_DAY));
		
		Assumptions.assumeTrue(gc.get(Calendar.HOUR_OF_DAY) < 22);
		
		employee.adjustSalary(5000);
		assertEquals(85000, employee.getSalary());
		
		System.out.println("The assumption was satisfied and the test was run.");
	}
	
	@Test
	void assumptionTest1() {
		
		System.out.println("Current hour: " + gc.get(Calendar.HOUR_OF_DAY));
		
		Assumptions.assumeFalse(gc.get(Calendar.HOUR_OF_DAY) < 20);
		
		employee.adjustSalary(5000);
		assertEquals(85000, employee.getSalary());
		
		System.out.println("The assumption was satisfied and the test was run.");
	}
	
	@Test
	void assumptionTest2() {
		
		System.out.println("Current hour: " + gc.get(Calendar.HOUR_OF_DAY));
		
		Assumptions.assumingThat(gc.get(Calendar.HOUR_OF_DAY) < 22,
				() -> { employee.adjustSalary(5000);
				   assertEquals(85000,employee.getSalary());
				   System.out.println("\nThe assumption was satisfied and the test was run.");
				});
		
		System.out.println("\nAfter the invocation of assuming That ");
	}
}

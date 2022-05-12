package com.skillsoft.junit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	/* Testing for Timeouts and Nulls using JUnit */
	
	static Employee firstEmployee;
	static Employee secondEmployee;
	
	@BeforeAll
	static void initEmployee() {
		
		firstEmployee = new Employee("Amy","Cruz",1001,'F',"Devloper",50000,"Permanent");
	}
	
	@Test
	void assertTest() {
		
		assertTimeout(Duration.ofSeconds(5), () -> {firstEmployee.adjustSalary(2000);});
	}
	
	@Test
	void assertTest1() {
		
		assertTimeout(Duration.ofSeconds(5), 
				() -> {firstEmployee.adjustSalary(2000);
				   Employee secondEmployee = new Employee("Biran","Alford",1011,'M',"Developer",45000,"Contract");
				   secondEmployee.adjustSalary(3000);});
	}
	
	@Test
	void assertTest2() {
		
		firstEmployee = new Employee("Amy","Cruz",1001,'F',"Devloper",50000,"Permanent");
		secondEmployee = null;
	}
	
	@Test
	void assertTest3() {
		
		assertNull(secondEmployee);
	}
	
	@Test
	void assertTest4() {
		
		assertNotNull(firstEmployee);
	}
}

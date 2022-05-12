package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.naming.NamingException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	/* Working with Specialized Assert Method in JUnit */
	
	static Employee firstEmployee;
	
	@BeforeAll
	static void initEmployee() {

		firstEmployee = new Employee("Susan","4ester",1005,'F',"Tech Lead",80000,"Permanent");		
	}
	
	@Test
	void assertTest() {
		firstEmployee.adjustSalary(4000);
		
		assertAll("Test Employee",
				() -> assertEquals(84000,firstEmployee.getSalary()),
				() -> assertNotNull(firstEmployee.getFirstName()),
				() -> assertThrows(NamingException.class,
						() -> {firstEmployee.validateLastName();},
						"Throws Exception test")
				);
		
	}
}

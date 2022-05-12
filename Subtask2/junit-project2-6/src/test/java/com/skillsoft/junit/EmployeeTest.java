package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;

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
		
		firstEmployee.addProjects("Blue Flame");
		firstEmployee.addProjects("Black Box");
		
		ArrayList<String> compareList = new ArrayList<>();
		compareList.add("Blue Flame");
		compareList.add("Black Box");
		
		assertIterableEquals(compareList, firstEmployee.getProjects());
	}
}

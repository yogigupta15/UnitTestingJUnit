package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import javax.naming.InvalidNameException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class EmployeeTest {
	
	/* Defining an argument converter in JUnit */
	
	static Stream<String> getLastNames(){
		return Stream.of("Al4d", "B3nson", "$mith", "@lford");
	}
	
	@ParameterizedTest
	@MethodSource("getLastNames")
	@DisplayName("Name Check")
	void nameTest(String lName) {
		
		Employee employee = new Employee("Brain", lName, 1011, 'M', "Devloper", 50000, "Contract");
		assertThrows(InvalidNameException.class, 
				() -> {employee.validateLastName();},
				"Throws Exception Test");
	}
	
	@ParameterizedTest(name = "Test #{index} - Last name: {0}")
	@MethodSource("getLastNames")
	@DisplayName("Name Check")
	void nameTest1(String lName) {
		
		Employee employee = new Employee("Brain", lName, 1011, 'M', "Devloper", 50000, "Contract");
		assertThrows(InvalidNameException.class, 
				() -> {employee.validateLastName();},
				"Throws Exception Test");
	}
}
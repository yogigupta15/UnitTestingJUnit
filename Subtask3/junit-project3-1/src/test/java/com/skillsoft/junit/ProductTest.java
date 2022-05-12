package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ProductTest {
	/* Setting a display name for a test case in JUnit and Running test in JUnit Based on OS */
	static Product tv;;
	
	@BeforeAll
	static void init() {
		
		tv = new Product("Diallonic","Delta",13423,800,"Electronics");	
	}
	
	@Test
	@DisplayName("Brand Name Check")
	@EnabledOnOs(OS.WINDOWS)
	void brandNameTest() {
		
		assertEquals("Diallonic", tv.getBrandName(),"Brand Name Test");
	}
	
	@Test
	@DisplayName("Price Check")
	@DisabledOnOs(OS.WINDOWS)
	void priceTest() {
		
		assertEquals(800, tv.getPrice(),"Price Test");
	}
	
	@Test
	@DisplayName("Category Check")
	@DisabledOnOs(OS.LINUX)
	void categoryTest() {
		
		assertEquals("Electronics",tv.getCategory(),"Category Test");
	}
}

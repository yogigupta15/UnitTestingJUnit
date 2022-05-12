package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class ProductTest {
	/* Turning Tests on or off Based on JRE VERSION */
	static Product tv;;
	
	@BeforeAll
	static void init() {
		
		tv = new Product("Diallonic","Delta",13423,800,"Electronics");	
	}
	
	@Test
	@DisplayName("Brand Name Check")
	@EnabledOnJre(JRE.JAVA_13)
	void brandNameTest() {
		
		assertEquals("Diallonic", tv.getBrandName(),"Brand Name Test");
	}
	
	@Test
	@DisplayName("Price Check")
	@EnabledForJreRange(min = JRE.JAVA_9 , max = JRE.JAVA_13)
	void priceTest() {
		
		assertEquals(800, tv.getPrice(),"Price Test");
	}
	
	@Test
	@DisplayName("Category Check")
	@DisabledForJreRange(max = JRE.JAVA_11)
	void categoryTest() {
		
		assertEquals("Electronics",tv.getCategory(),"Category Test");
	}
}

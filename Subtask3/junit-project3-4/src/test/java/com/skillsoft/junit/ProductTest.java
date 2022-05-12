package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ProductTest {
	
/* Checking for Environment Variables and multiple conditions */
	
	static Product tv;
	
	@BeforeAll
	static void init() {
		
		tv = new Product("Diallonic", "Delta", 13423, 800, "Electronics");
		 
		 System.out.println("Environment variables: ");
		 System.out.println("PROCESSOR_LEVEL : " + System.getenv("PROCESSOR_LEVEL"));
		 System.out.println("USERDOMAIN :" + System.getenv("USERDOMAIN"));
		 System.out.println("ALL :" + System.getenv());
	}
	
	 @Test
	 @DisplayName("Brand Name Check")
	 @EnabledIfEnvironmentVariable(named = "PROCESSOR_LEVEL", matches = "6")
	 @EnabledForJreRange(max = JRE.JAVA_13)
	 void brandNameTest() {
		 
		 assertEquals("Diallonic",tv.getBrandName(), "Brand Name Test");
	 }
	 
	 @Test
	 @DisplayName("Price Check")
	 @EnabledIfEnvironmentVariable(named = "USERDOMAIN", matches = "AMERICAS")
	 @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_16)
	 void priceTest() {
		 
		 assertEquals(800, tv.getPrice(), "Price Test");
	 }
	 
	 @Test
	 @DisplayName("Category Check")
	 @DisabledIfEnvironmentVariable(named = "USERDOMAIN", matches = "AMERICAS")
	 @EnabledOnOs(OS.WINDOWS)
	 void categoryTest() {
		 
		 assertEquals("Electronics", tv.getCategory(), "Category Test");
	 }
	 
	 @Test
	 @DisplayName("Model Check")
	 @DisabledIfEnvironmentVariable(named = "LANG", matches = "de_DE*")
	 @DisabledForJreRange(min = JRE.JAVA_10)
	 void modelTest() {
		 
		 assertEquals("Delta", tv.getModel(), "Model Test");
	 }
}

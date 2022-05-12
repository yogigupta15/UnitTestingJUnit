package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ProductTest {
	
	/* Composed annotation in JUnit */
	
	static Product tv;
	
	@BeforeAll
	 static void init() {
		 
		 tv = new Product("Diallonic", "Delta", 13423, 800, "Electronics");
	 }
	
	@Retention(RetentionPolicy.RUNTIME)
	@Test
	@EnabledForJreRange(min=JRE.JAVA_11,max=JRE.JAVA_16)
	@EnabledOnOs(OS.WINDOWS)
	@EnabledIfSystemProperty(named = "os.arch",matches = "amd64")
	public @interface MyCustomeTestConditions {		
	}
	
	@MyCustomeTestConditions
	@DisplayName("Brand Name Check")
	void brandName() {
		assertEquals("Diallonic",tv.getBrandName(), "Brand Name Test");
	}
	
	@MyCustomeTestConditions
	@EnabledIfEnvironmentVariable(named = "USER", matches = "null")
	@DisplayName("Price Check")
	void priceTest() {
		 
		 assertEquals(800, tv.getPrice(), "Price Test");
	}
	
	@MyCustomeTestConditions
	@DisplayName("Category Check")
	@DisabledIfEnvironmentVariable(named = "USER", matches = "null")
	void categoryTest() {
		 
		 assertEquals("Electronics", tv.getCategory(), "Category Test");
	}
	
	@MyCustomeTestConditions
	@DisplayName("Model Check")
	@EnabledIfEnvironmentVariable(named = "USER",matches = "skill.*")
	void modelTest() {
		 
		 assertEquals("Delta", tv.getModel(), "Model Test");
	}
}

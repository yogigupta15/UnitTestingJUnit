package com.skillsoft.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class RoleConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object source, Class<?> target) {
		
		assertEquals(String.class, target);
		return String.valueOf(source).toUpperCase();
	}

}

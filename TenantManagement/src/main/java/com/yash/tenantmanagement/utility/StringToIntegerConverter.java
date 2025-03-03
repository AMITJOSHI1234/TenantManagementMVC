package com.yash.tenantmanagement.utility;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class StringToIntegerConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String value) {
		// TODO Auto-generated method stub
		return Integer.parseInt(value);
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

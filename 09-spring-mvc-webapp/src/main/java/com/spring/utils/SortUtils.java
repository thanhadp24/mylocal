package com.spring.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.springmvc.entity.Customer;

public class SortUtils {
	private SortUtils() {
	}

	public static Map<String, Function<Customer, String>> CUSTOMER_SORT_PROPERTIES = new HashMap<String, Function<Customer, String>>() {

		private static final long serialVersionUID = 1L;

		{
			put("first_name", Customer::getFirstName);
			put("last_name", Customer::getLastName);
			put("email", Customer::getEmail);
		}

	};
}

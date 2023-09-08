package model;

import java.util.Arrays;
import java.util.List;

import bean.Customer;

public class DataModel {
	private DataModel() {
	}
	
	public static List<Customer> getCustomers(){
		return Arrays.asList(
				new Customer(1, "Suzan", 28, "Milan"),
				new Customer(2, "Toto", 18, "porto"),
				new Customer(3, "henry", 22, "Paris"),
				new Customer(4, "Smith", 36, "London"),
				new Customer(5, "Totti", 43, "Lepzig")
		);
	}
}

package model;

import bean.ItemDetail;

public class DataModel {
	private DataModel() {
		
	}
	
	public static ItemDetail[] getItemDetails() {
		return new ItemDetail[] {
			new ItemDetail(101, 1, "item 101", 35),
			new ItemDetail(201, 1, "item 201", 100),
			new ItemDetail(301, 13, "item 301", 121),
			new ItemDetail(401, 13, "item 401", 351),
			new ItemDetail(102, 6, "item 102", 123),
			new ItemDetail(202, 11, "item 202", 30),
			new ItemDetail(302, 6, "item 302", 315)
		};
	}
	
	public static ItemDetail[] getItemDetailsWithNullValue() {
		return new ItemDetail[] {
			null,null,
			new ItemDetail(101, 1, "item 101", 35),
			new ItemDetail(201, 1, "item 201", 100),
			new ItemDetail(301, 13, "item 301", 121),
			new ItemDetail(401, 13, "item 401", 351),
			null,
			new ItemDetail(102, 6, "item 102", 123),
			new ItemDetail(202, 11, "item 202", 30),
			new ItemDetail(302, 6, "item 302", 315),
			null,
		};
	}
}

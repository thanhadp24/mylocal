package common;

public enum DayOfWeeks {
	SUNDAY("Chủ nhật"),
	MONDAY("Thứ 2"),
	TUESDAY("Thứ 3"),
	WEDNESDAY("Thứ 4"),
	THURSDAY("Thứ 5"),
	FRIDAY("Thứ 6"),
	SATURDAY("Thứ 7");
	
	private String wdAsString;
	
	DayOfWeeks (String wdAsString) {
		this.wdAsString = wdAsString;
	}
	
	@Override
	public String toString() {
		return wdAsString;
	}
}

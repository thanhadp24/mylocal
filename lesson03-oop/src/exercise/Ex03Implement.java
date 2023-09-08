package exercise;

import java.awt.print.Printable;

public class Ex03Implement {
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("Nguyễn Thu Loan", "Future Neo", 100, 35000000);
		Vehicle vehicle2 = new Vehicle("Lê Minh Tính", "Ford Ranger", 3000, 250000000);
		Vehicle vehicle3 = new Vehicle("Lê Minh Tuấn", "Landscape", 1500, 1000000000);
		
		Vehicle[] elements = {vehicle1, vehicle2, vehicle3}; 

		System.out.printf("%-20s %-15s %-10s %15s %20s", "tên chủ xe", "loại xe", "dung tích", "giá trị", "thuế phải trả");
		System.out.println("\n====================================================================================");
		for (Vehicle element: elements) {
			double tax = getTaxPayable(element);
			element.setTaxPayable(tax);
			System.out.println(element);
		}
	}

	private static double getTaxPayable(Vehicle vehicle) {
		double tax = 0;
		double price = vehicle.getPrice();
		if (vehicle.getEngineCapicity() < 100) {
			tax = price * 0.01;
		} else if (vehicle.getEngineCapicity() < 200) {
			tax = price * 0.03;
		} else {
			tax = price * 0.05;
		}

		return tax;
	}
}

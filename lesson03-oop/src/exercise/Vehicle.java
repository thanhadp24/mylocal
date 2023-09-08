package exercise;

public class Vehicle {
	private String vehicleOwner;
	private String vehicleType;
	private int engineCapacity;
	private double price;
	private double taxPayable;

	public Vehicle() {
	}

	public Vehicle(String vehicleOwner, String vehicleType, int engineCapacity, double price) {
		this.vehicleOwner = vehicleOwner;
		this.vehicleType = vehicleType;
		this.engineCapacity = engineCapacity;
		this.price = price;
	}

	public String getVehicleOwner() {
		return vehicleOwner;
	}

	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getEngineCapicity() {
		return engineCapacity;
	}

	public void setEngineCapicity(int engineCapicity) {
		this.engineCapacity = engineCapicity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTaxPayable() {
		return taxPayable;
	}

	public void setTaxPayable(double taxPayable) {
		this.taxPayable = taxPayable;
	}

	@Override
	public String toString() {
		return String.format("%-20s %-15s %-10d %15.2f %20.2f", vehicleOwner, vehicleType, engineCapacity, price,
				taxPayable);
	}

}

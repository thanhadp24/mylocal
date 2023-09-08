package bean;

import java.util.Objects;

public class WareHouse {
	
	private String whId;
	private String address;
	
	public WareHouse() {
	}

	public WareHouse(String whId, String address) {
		this.whId = whId;
		this.address = address;
	}
 
	public String getWhId() {
		return whId;
	}

	public void setWhId(String whId) {
		this.whId = whId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "WareHouse [whId=" + whId + ", address=" + address + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// mặc định: so sánh địa chỉ của đối tượng 
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof WareHouse)) {
			return false;
		}
		
		WareHouse that = (WareHouse) obj;
		return getWhId().equals(that.getWhId());
	}
	
	// 2 đối tượng là equals nếu trùng id và address
	// ==> trùng hashcode 
	
	// nếu mình equals các thuộc tính nào thì phải hashcode theo cái thuộc tính đó
	
	@Override
	public int hashCode() {
		// mặc định: địa chỉ của đối tượng
		return Objects.hash(getWhId());
	}
}

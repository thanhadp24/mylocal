package bean;

// create immutable object but can change value

public class UserLv3 {

	private String name;
	private int age;
	private String phone;
	private String address;

	private UserLv3() {
	}
	
	public static UserLv3 of() {
		return new UserLv3();
	}

	public UserLv3 name(String name) {
		UserLv3 newOne = clone();
		newOne.name = name;
		return newOne;
	}

	public UserLv3 age(int age) {
		UserLv3 newOne = clone();
		newOne.age = age;
		return newOne;
	}

	public UserLv3 phone(String phone) {
		UserLv3 newOne = clone();
		newOne.phone = phone;
		return newOne;
	}

	public UserLv3 address(String address) {
		UserLv3 newOne = clone();
		newOne.address = address;
		return newOne;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public UserLv3 clone() {
		UserLv3 newOne = new UserLv3();
		newOne.name = this.name;
		newOne.age = this.age;
		newOne.phone = this.phone;
		newOne.address = this.address;
		return newOne;
	}
	
	@Override
	public String toString() {
		return "UserLv3 [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + "]";
	}

}

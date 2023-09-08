package bean;

// create class can change value

public class UserLv2 {

	private String name;
	private int age;
	private String phone;
	private String address;

	private UserLv2() {
	}
	
	public static UserLv2 of() {
		return new UserLv2();
	}
	
	public UserLv2 name(String name) {
		this.name = name;
		return this;
	}

	public UserLv2 age(int age) {
		this.age = age;
		return this;
	}

	public UserLv2 phone(String phone) {
		this.phone = phone;
		return this;
	}

	public UserLv2 address(String address) {
		this.address = address;
		return this;
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

	@Override
	public String toString() {
		return "UserLv2 [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + "]";
	}

}

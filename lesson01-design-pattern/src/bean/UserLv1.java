package bean;
// create immutable object without change values
public class UserLv1 {
	
	private final String name;
	private final int age;
	private final String phone;
	private final String address;
	
	public UserLv1(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public static Builder builder() {
		return new Builder();
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
		return "UserLv1 [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + "]";
	}
	
	public static class Builder {
		private String name;
		private int age;
		private String phone;
		private String address;
		
		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withAge(int age) {
			this.age = age;
			return this;
		}

		public Builder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public UserLv1 build() {
			return new UserLv1(this);
		}
	}
	
}

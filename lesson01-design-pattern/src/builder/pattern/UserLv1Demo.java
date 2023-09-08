package builder.pattern;

import bean.UserLv1;

public class UserLv1Demo {
	
	public static void main(String[] args) {
		UserLv1 ul1 = UserLv1.builder().withName("thanh").withAge(19).build();
		System.out.println("ul1 --> " + ul1);
		
		UserLv1 ul2 = UserLv1.builder().withName("ba dao").withPhone("1234").withAge(5).build();
		System.out.println("ul2 --> " + ul2);
	}
}

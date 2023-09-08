package builder.pattern;

import bean.UserLv2;

public class UserLv2Demo {

	public static void main(String[] args) {
		UserLv2 ul1 = UserLv2.of().name("thanh").age(19);
		System.out.println("ul1 --> " + ul1);
		
		ul1.age(20).address("quang nam");
		System.out.println("ul1 after updated --> " + ul1);
	}
}

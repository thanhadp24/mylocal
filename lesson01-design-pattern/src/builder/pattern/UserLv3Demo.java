package builder.pattern;

import bean.UserLv3;

public class UserLv3Demo {
	
	public static void main(String[] args) {
		UserLv3 ul1 = UserLv3.of().name("thanh").address("quang da");
		ul1 = ul1.name("teo");
		System.out.println("ul1 --> " + ul1);
	}
}

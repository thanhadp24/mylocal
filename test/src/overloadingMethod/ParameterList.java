package overloadingMethod;

public class ParameterList {
	// có thể truyền bao nhiêu tham số cx đc
	public static int sum(int ...arr) {
		int s = 0;
		for(int i = 0; i < arr.length; i++) {
			s += arr[i];
		}
		return s;
	}
	public static void main(String[] args) {
		int x = sum(1,2,10);
		System.out.println(x);
	}
}

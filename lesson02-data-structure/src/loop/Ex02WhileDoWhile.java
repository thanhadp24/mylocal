package loop;

public class Ex02WhileDoWhile {
	public static void main(String[] args) {
		int n = 6;
		int i = 0;
		while(true) {
			System.out.print(i + " ");
			i += 2;
			
			if(i == n) {
				break;
			}
		}
		System.out.println("\n============");
		System.out.println("Finished");
		
		int m = 8;
		int k = 0;
		do {
			System.out.print(k + " ");
			if(k >= m) {
				break;
			}
			k++;
		} while(true);
	}
}

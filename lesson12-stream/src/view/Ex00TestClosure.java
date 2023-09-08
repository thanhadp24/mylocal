package view;

public class Ex00TestClosure {
	public static void main(String[] args) {
		Runnable runnable = test(15);
		
		runnable.run();
	}
	
	public static Runnable test(int time) {
		String running = "running...";
		// nested object which is call in lambda
		// copy initial value and store in lambda
		// --> running: closure variable
		return new Runnable() {
			
			@Override
			public void run() {
				System.out.println("tom is " + running + " " + time + " ms");
			}
		};
	}
}

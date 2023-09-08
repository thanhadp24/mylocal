package view;

public class ThreadDemo {
	static int sum = 100;

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				sum += 3;
				System.out.println("sum t1: " + sum);
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				sum += 5;
				System.out.println("sum t2: " + sum);
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum: " + sum);
	}
	
}

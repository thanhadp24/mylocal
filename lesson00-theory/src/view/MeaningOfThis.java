package view;

public class MeaningOfThis {
	private static final int value = 4;

	public void doIt() {
		int value = 6;

		Runnable r = new Runnable() {
			public final int value = 5;

			@Override
			public void run() {
				int value = 10;
				System.out.println(this.value); // 5
			}
		};
		r.run();
	}

	public static void main(String[] args) {
		MeaningOfThis mot = new MeaningOfThis();
		mot.doIt();

	}
}

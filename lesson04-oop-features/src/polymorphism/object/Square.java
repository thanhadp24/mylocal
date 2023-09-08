package polymorphism.object;

public class Square extends Shape {

	@Override
	void draw() {
		System.out.println("square ==> draw");
	}

	@Override
	void calS() {
		System.out.println("square ==> calS");
	}
	
	void setBackground() {
		System.out.println("square ==> setBackground");
	}
}

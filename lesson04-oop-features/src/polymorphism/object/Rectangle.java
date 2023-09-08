package polymorphism.object;

public class Rectangle extends Shape {
	@Override
	void calS() {
		System.out.println("rectangle ==> draw");
	}

	@Override
	void draw() {
		System.out.println("rectangle ==> calS");
	}
	
	void setBackground() {
		System.out.println("rectangle ==> setBackground");
	}

}

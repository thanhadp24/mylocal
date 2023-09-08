package inheritance.iinterface;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("drawing a rectangle");
	}

	@Override
	public void calS() {
		System.out.println("width * height");
	}

}

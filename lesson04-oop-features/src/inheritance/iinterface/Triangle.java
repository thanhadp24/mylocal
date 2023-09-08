package inheritance.iinterface;

public class Triangle implements Shape{

	@Override
	public void draw() {
		System.out.println("drawing a triangle");
		
	}

	@Override
	public void calS() {
		System.out.println("1/2 * heigh * bottom side");
	}
	
}

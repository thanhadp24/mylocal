package inheritance.iinterface;

public class ShapeDemo {
	public static void main(String[] args) {
		Shape shapeRect = new Rectangle();
		shapeRect.draw();
		shapeRect.calS();
		
		System.out.println("========");
		// anonymous class
		Shape shapeTriangle = new Shape() {
			
			@Override
			public void draw() {
				System.out.println("drawing a triangle");
			}
			
			@Override
			public void calS() {
				System.out.println("1/2 * heigh * bottem side");
			}
		};
		shapeTriangle.draw();
		shapeTriangle.calS();
		
		System.out.println("==========");
		
		Shape shapeTriangle2 = new Triangle();
		shapeTriangle2.draw();
		shapeTriangle2.calS();
	}
}

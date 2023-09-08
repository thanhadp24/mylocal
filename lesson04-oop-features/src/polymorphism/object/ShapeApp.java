package polymorphism.object;

public class ShapeApp {
	/**
	 * 1. Tại sao không khai báo KDL lúc compile và runtime giống nhau
	 * + Áp dụng factory pattern (tạo ra các pattern: rectangle, square,...)
	 * + Dễ dàng chuyển đổi KDL qua về
	 * + Tạo tập hợp các phần tử KDL cha, con đưa vào 1 mảng duy nhất
	 * + Convention
	 * 2. Nếu lấy KDL của lớp con new(gán =) KDL của lớp cha được không
	 * + Cha = con --> oke
	 * + Else      --> no	
	 * 3. Lấy KDL lúc compile và runtime không có quan hệ được không
	 * + không
	 */
	public static void main(String[] args) {
		Shape shapeRect = ShapeFactory.createShape(ShapeType.RECTANGLE);
		shapeRect.draw();
		shapeRect.calS();
		
		System.out.println("===========");
		
		Shape shapeSquare = ShapeFactory.createShape(ShapeType.SQUARE);
		shapeSquare.draw();
		shapeSquare.calS();
		
		shapeRect = shapeSquare;	
		
		Rectangle rect = new Rectangle();
		
		Shape[] shapes = {shapeRect, shapeSquare, rect};
		System.out.println(shapes.length);
		
		System.out.println("================");
		
		Shape s1 = new Rectangle();
		s1.draw();
		//Rectangle r1 =(Rectangle)new Shape();
		//r1.setBackground();
		
		Shape r2 = new Square();
		// ((Square)(r2)).setBackground();  ==> bản chất lúc runtime hỉu đc r2 thuộc KDL nào thì nó mới cho ép sang KDL đó
		// ((Rectangle)(r2)).setBackground();
		if(r2 instanceof Square) {
			Square sq1 = (Square)r2;
			sq1.setBackground();	
		} else if(r2 instanceof Rectangle) {
			Rectangle rect1 = (Rectangle)r2;
			rect1.setBackground();
		}
		
	}
}

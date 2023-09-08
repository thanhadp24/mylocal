package polymorphism.object;

public class ShapeFactory {
	private ShapeFactory() {
		
	}

	public static Shape createShape(ShapeType shapetype) {
		switch (shapetype) {
		case RECTANGLE:
			return new Rectangle();
		case SQUARE:
			return new Square();
		}
		return new Shape();
	}
}

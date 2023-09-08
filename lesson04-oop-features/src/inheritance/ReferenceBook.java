package inheritance;

/**
 *	Book: id, name, price, publisher
 *	ReferenceBook:Book (id, name, price, publisher) + tax
 *
 */
public class ReferenceBook extends Book{
	
	private double tax;
	
	public ReferenceBook() {
		
	}
	
	public ReferenceBook(String id, String name, double price, String publisher, double tax) {
		//this.setId(id);
		//this.setName(name);
		//this.setPrice(price);
		//this.setPublisher(publisher);
		
		super(id, name, price, publisher);
		this.tax = tax;
	}
	
	public double getTax(double tax) {
		return tax;
	}
	
	public void setTax(double tax)
	{
		this.tax = tax;
	}
	
	@Override
	public String toString() {
 		return super.toString() + ", tax = " + tax;
	}
	//ReferenceBook rb = new ReferenceBook(,,,,);
}

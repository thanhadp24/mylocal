package bean;

/**
 * Kiểu dữ liệu Item,Tự định nghĩa
 * + Mã id
 * + Name
 * + Price
 * @author ASUS
 */
public class Item {
	// cấu trúc dữ liệu -->biến ,thuộc tính.
	// thuật toán --> hàm,phương thức.
	public int itemId; // itemId: thuộc tính 
	public String name;
	public double price;	
	
	// hàm khởi tạo rỗng mặc định
	// tạo ra ô nhớ ở Heap với các giá trị mặc định của thuộc tính 
	// chưa gán giá trị cho thuộc tính
	public Item(){
		// sẽ mất đi khi mình thêm hàm khởi tạo khác
	}
	
	// contructor
	public Item(int itemIdPr, String namePr, double pricePr ) {
		this.itemId = itemIdPr;
		this.name = namePr;
		this.price = pricePr;
	}
	
	// itemA.toString()
	// itemB.toString()
	
	
	@Override
	public String toString() {
		return this.itemId + ", " + this.name + ", " + this.price; 
	}
}

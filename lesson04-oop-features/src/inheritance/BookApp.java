package inheritance;

public class BookApp {
	public static void main(String[] args) {
		TextBook tb1 = new TextBook("tb1", "math", 120, "nd", Level.ADVANCED);
		TextBook tb2 = new TextBook("tb2", "english", 200, "nd", Level.BASIC);
		
		ReferenceBook rb3 = new ReferenceBook("rb3", "trên đường băng", 300, "tony", 50);
			
		Book[] books = {tb1, tb2, rb3};
		
		for(Book book: books) {
			// if(book.getClass() == ReferenceBook.class)
			if(	book instanceof ReferenceBook) {  // duyệt xem từng phần tử có interface với ref không(đối tượng của ref k)
				ReferenceBook rb = (ReferenceBook)book; // ép kiểu vì phần tử thuộc kiểu book nên k thể truy cập phương thức của thèn ref
				System.out.println("tax: " + rb.getTax(0));
			}
		}
		
		System.out.println(tb1);
		System.out.println(tb2);
		System.out.println(rb3);
	}
}

package view;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

import java.util.Arrays;

import bean.ItemDetail;
import model.DataModel;

public final class Ex08rrayortWithItemDetailV3 {
	public static void main(String[] args) {

		ItemDetail[] items = DataModel.getItemDetails();
		
		// ItemDetail implement Comparable<ItemDetail> 
		Arrays.sort(items);
		System.out.println("1st sorted items; " + Arrays.toString(items));
		
		
		// Comparator<ItemDetail>
		Arrays.sort(items, comparing(ItemDetail::getStoreId, reverseOrder()).thenComparing(ItemDetail::getPrice));
		
		System.out.println("2nd sorted items: " + Arrays.toString(items));
	
		// Refer --> 2nd way
		// + Reduce code in T class
		// + Catch errors at complie
		// + Comparable supports multiple sorting functions concurrent
		
	}

}

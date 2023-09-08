package view;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsFirst;
import static java.util.Comparator.reverseOrder;

import java.util.Arrays;
import java.util.Comparator;

import bean.ItemDetail;
import model.DataModel;

public class Ex06ArraysSortWithItemDetailV2 {
	public static void main(String[] args) {
		ItemDetail[] items = DataModel.getItemDetails();
		
//		Arrays.sort(items, new Comparator<ItemDetail>() {
//
//			// order by storeId ASC
//			@Override
//			public int compare(ItemDetail o1, ItemDetail o2) {
//				return o1.getStoreId() - o2.getStoreId();
//			}
//		});
		
		/*
		 T: generic
		 ?: wildcard
		 ? super T: T or parent of T
		 
		 public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> function){
	        Objects.requireNonNull(keyExtractor);
	        return (Comparator<T> & Serializable)
	            (i1, i2) -> function.apply(i1)[i1.getItemId()].compareTo(function.apply(i2)) [(i2.getItemId())];
	    	}		  
		 */
		
		// itemDetail -> itemDetail.getPrice() <==> ItemDetail::getPrice ==> method reference
		 Comparator<ItemDetail> comparator = Comparator.comparing(itemDetail -> itemDetail.getPrice());	
		
		 Arrays.sort(items, comparator);
		 
		
		 
		 // order by itemId ASC
		 // reverseOrder --> giảm dần
		Arrays.sort(items, comparing(ItemDetail::getStoreId, reverseOrder()).thenComparing(ItemDetail::getItemId));
		System.out.println(Arrays.toString(items));
	
		Arrays.sort(items, nullsFirst(comparing(ItemDetail::getStoreId, reverseOrder()).thenComparing(ItemDetail::getItemId)));
		System.out.println(Arrays.toString(items));
	
	}
	
}

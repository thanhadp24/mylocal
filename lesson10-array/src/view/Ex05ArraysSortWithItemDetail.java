package view;

import java.util.Arrays;
import java.util.Comparator;

import bean.ItemDetail;
import model.DataModel;

public class Ex05ArraysSortWithItemDetail {
	public static void main(String[] args) {
		ItemDetail[] items = DataModel.getItemDetails();
		
		Arrays.sort(items, new Comparator<ItemDetail>() {

			@Override
			public int compare(ItemDetail o1, ItemDetail o2) {
				
				int storeId1 = o1.getStoreId();
				int storeId2 = o2.getStoreId();
				
				if (storeId1 != storeId2) {
					return storeId1 - storeId2;
				}
				
				int itemId1 = o1.getItemId();
				int itemId2 = o2.getItemId();
				
				return itemId2 - itemId1;
			}
			
		});
		
		System.out.println(Arrays.toString(items));
		
		System.out.println("================");
		
		ItemDetail[] items1 = DataModel.getItemDetailsWithNullValue();
		
		Arrays.sort(items1, (i1, i2) -> {
			if (i1 == null) {
				return 1;
			}
			
			if (i2 == null) {
				return -1;
			}
			
			int storeId1 = i1.getStoreId();
			int storeId2 = i2.getStoreId();
			
			if (storeId1 != storeId2) {
				return storeId1 - storeId2;
			}
			
			int itemId1 = i1.getItemId();
			int itemId2 = i2.getItemId();
			
			return itemId2 - itemId1;
		});
		
		System.out.println(Arrays.toString(items1));
	}
}

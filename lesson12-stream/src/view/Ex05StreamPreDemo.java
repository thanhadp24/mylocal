package view;

import static java.util.Comparator.comparing;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import model.DataModel;

public class Ex05StreamPreDemo {
	public static void main(String[] args) {
		 List<Dish> menu = DataModel.getDishes();
		 
		 System.out.println("1. Get dishes which have calories > 450g");

		 // stream --> traversable once --> bất tiện
		 
		List<Dish> weightCalories = menu.stream() // Stream<Dish> 
		 	 .filter(d -> d.getCalories() > 450) // Stream<Dish>
		 	 .collect(Collectors.toList());
		 
		weightCalories.forEach(System.out::println);
		
		System.out.println("\n2. Get name of dishes");
		
		Set<String> nameOfDishes = menu.stream()
			.map(Dish::getName) // Stream<String>
			.collect(Collectors.toSet());
		nameOfDishes.forEach(System.out::println);
	
		String names = menu.stream()
						  .map(Dish::getName)
						  .collect(Collectors.joining(", "));
		System.out.println(names );
		
		System.out.println("\n3. Get name of dishes which are vegetarian food");
		
		Set<String> nameOfVegetarianFood = menu.stream()
			.filter(Dish::isVegetarian)
			.map(Dish::getName)
			.collect(Collectors.toSet());
		
		System.out.println(nameOfVegetarianFood);
		
		System.out.println("4. Sort a vehicle model map");
		
		Map<Integer, String> modelMap = DataModel.getVehicleModelMap();
		Map<Integer, String> sortedMap = modelMap.entrySet() // Set<Entry<Integer, String>>
				.stream()  // Stream<Entry<Integer, String>>
				.sorted(comparing(Entry::getValue))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println("instance " + sortedMap.getClass());
		sortedMap.forEach((k, v) -> System.out.println(k + " " + v));
		
		// Stream<Item(itemId, storeId, name)>
		// 1, s1, item1 --> (e1, e2) -> e1
		// 2, s2, item2
		// 3, s3, item3
		// 1, s2, item1 --> (e1, e2) -> e2	 
		
		// stream.collect(Collectors.toMap(Item::getId, Item::getStoreId));
	}		
}

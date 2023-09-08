package view;

import static common.Type.FISH;
import static common.Type.MEAT;
import static common.Type.OTHER;

import java.util.Arrays;
import java.util.List;

import bean.Dish;

public class DishDemo {
	public static void main(String[] args) {
		List<Dish> menu = mockData();
		
	
	}
	
	private static List<Dish> mockData(){
		return Arrays.asList (
			new Dish("pork", false, 800, MEAT),
			new Dish("beef", false, 700, MEAT),
			new Dish("chicken", false, 400, MEAT),
			new Dish("french fries", true, 530, OTHER),
			new Dish("rice", true, 350, OTHER),
			new Dish("season fruit", true, 120, OTHER),
			new Dish("pizza", true, 550, OTHER),
			new Dish("prawns", false, 300, FISH),
			new Dish("salmon", false, 450, FISH)
			);
	}
}

package model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Dish;
import bean.Dish.Kind;
import bean.Store;

public class DataModel {
	
	public static BigDecimal bd(long value) {
		return BigDecimal.valueOf(value);
	}
	
	public static List<Store> getStores(){
		return Arrays.asList(
				new Store(1L, null, bd(18), bd(40), Boolean.TRUE),
				new Store(2L, null, bd(19), bd(20), Boolean.TRUE),
				new Store(3L, null, bd(21), bd(17), Boolean.TRUE),
				new Store(4L, null, bd(14), bd(31), Boolean.TRUE),
				new Store(5L, null, bd(14), bd(10), Boolean.TRUE),
				new Store(6L, null, bd(29), bd(30), Boolean.TRUE),
				new Store(7L,   2L, bd(29), null, Boolean.TRUE),
				new Store(8L, null, bd(12), bd(19), Boolean.TRUE),
				new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
				new Store(10L,  7L, bd(18), null, Boolean.TRUE),
				new Store(11L, null, bd(22), null, Boolean.FALSE)
				);
	}
	
	public static List<Dish> getDishes(){
		return Arrays.asList(
				new Dish("1", "D1", 308, Kind.FISH, false),
				new Dish("2", "D2", 620, Kind.OTHER, true),
				new Dish("3", "D3", 329, Kind.OTHER, true),
				new Dish("4", "D4", 308, Kind.MEAT, false),
				new Dish("5", "D5", 480, Kind.MEAT, false),
				new Dish("6", "D6", 480, Kind.MEAT, false),
				new Dish("7", "D7", 818, Kind.MEAT, false)
				);
	}
	
	public static Map<Integer, String> getVehicleModelMap() {
		Map<Integer, String> vnVehicleModel = new HashMap<>();
		vnVehicleModel.put(73, "Quảng Bình");
		vnVehicleModel.put(43, "Đà Nẵng");
		vnVehicleModel.put(75, "Thừa Thiên Huế");
		vnVehicleModel.put(92, "Quảng Nam");
		vnVehicleModel.put(74, "Quảng Trị");

		return vnVehicleModel;
	}
}

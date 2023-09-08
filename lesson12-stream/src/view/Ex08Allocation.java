package view;

import static model.DataModel.bd;
import static model.DataModel.getStores;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import bean.Store;

public class Ex08Allocation {
	public static void main(String[] args) {
		List<Store> stores = getStores();
		
		// 1. Get all stores which have stock previous day greater than 15
		System.out.println("1. Get all stores which have stock previous day greater than 15");
		stores.stream()
			  .filter(s -> s.getStockPreviousDay().compareTo(bd(15)) > 0)
			  .forEach(System.out::println);
		
		
		// 2. Get all stores which have stock previous day greater than expected sales today
		// and sort them storeId descending
		System.out.println("\n2. Get all stores which have stock previous day greater than expected sales today\r\n"
				+ "	 and sort them storeId descending");
		stores.stream()
			  .filter(s -> s.getNonNullStockPreviousDay().compareTo(s.getNonNullExpectedSales()) > 0)
			  .sorted(comparing(Store::getStoreId).reversed())
			  .forEach(System.out::println);
		
		
		// 3. Get store no have reference store and return list of store ids
		System.out.println("\n3. Get store no have reference store and return list of store ids");
		stores.stream()
			  .filter(s -> s.getReferenceStoreId() == null)
			  .map(Store::getStoreId)
			  .forEach(System.out::println);
		
		// 4. Distinct store by stock previous day
		System.out.println("\n4. Distinct store by stock previous day");
		stores.stream()
			  .map(Store::getStockPreviousDay)
			  .distinct()
			  .forEach(System.out::println);
		
		
		stores.stream()
			  .filter(distinctBy(store -> store.getStockPreviousDay()))
			  .forEach(System.out::println);
		
		
		
		// 5. Get first two stores with max expected sales
		System.out.println("\n5. Get first two stores with max expected sales");
		
		stores.stream()
			  .filter(store -> store.getExpectedSales() != null)
			  .sorted(Comparator.comparing(Store::getExpectedSales).reversed())
			  .limit(2)
			  .forEach(System.out::println);
		
		
		// 6. Get list of reference stores
		System.out.println("\n6. Get list of reference stores");
		stores.stream()
			  .map(Store::getReferenceStoreId)
			  .filter(Objects::nonNull)
			  .forEach(System.out::println);

		// 7. Is there any store has no expected sales
		System.out.println("\n7. Is there any store has no expected sales");
		boolean IsExist = stores.stream()
			  .anyMatch(store -> store.getExpectedSales() == null);
		
		System.out.println("IsExist: " + IsExist);
		
		/*
		 * 8. Calculate and return list of store's expected sales which has no expected sales
		 * - store has not expected sales but:
		 * + has reference store which maintained expected sales
		 *  --> use expected sales of reference store
		 * + has reference store which no maintained expected sales
		 *  --> use average of store's expected sales with it's own(reference store not count)
		 * + has no reference store
		 *  -->  --> use average of store's expected sales with it's own(reference store not count)
		 *  
		 */
		
		
		
		// 9. calculate sum of expected sales today
		System.out.println("\n 9. calculate sum of expected sales today");
		BigDecimal sumOfExpectedSales = stores.stream()
			  .map(Store::getNonNullExpectedSales)
			  .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		System.out.println("sumOfExpectedSales " + sumOfExpectedSales);
		
		// 10. Find store which has max stock previous day
		// if many stores have same stock previous day, use the one with smallest store id
		System.out.println("-- Question 10 --");
		stores.stream()
			  .filter(store -> store.getStockPreviousDay() != null)
			  .sorted(comparing(Store::getStockPreviousDay, reverseOrder()).thenComparing(Store::getStoreId))
			  .limit(1)
			  .forEach(System.out::println);
	 }
	
	// closure
	private static <T, R> Predicate<T> distinctBy(Function<T, R> function){
		Set<R> storage = new HashSet<>();
		return t -> storage.add(function.apply(t));
	}
	
}

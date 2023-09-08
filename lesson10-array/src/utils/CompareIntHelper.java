package utils;
@FunctionalInterface
public interface CompareIntHelper {
	boolean compare(int pre, int next);

	// functional interface 
	// instead of new interface and override  abstract method to creater an interface instance
	
	// using lamda expression to creater instance of functional interface
}
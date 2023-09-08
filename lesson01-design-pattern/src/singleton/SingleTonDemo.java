package singleton;

public class SingleTonDemo {
	public static void main(String[] args) {
		SingletonClass s1 = SingletonClass.getInstance();
		System.out.println("s1 heap " + System.identityHashCode(s1));
		s1.setTestValue("regression");
		
		SingletonClass s2 = SingletonClass.getInstance();
		System.out.println("s2 heap " + System.identityHashCode(s2));
		System.out.println("s2-->" + s2.getTestValue());
		System.out.println("finished!!!");
		
		System.out.println("=================");
		
		Singleton st1 = Singleton.getInstance();
		st1.setValue(10);
		System.out.println("st1 address --> " + System.identityHashCode(st1));
		System.out.println("st1 --> " + st1);
		
		Singleton st2 = Singleton.getInstance();
		System.out.println("st2 address --> " + System.identityHashCode(st2));
		System.out.println("st2 --> " + st2);
	}
}

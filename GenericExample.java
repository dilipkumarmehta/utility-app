package com.dilp.java8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class GnericExample {
	public static void main(String[] args) {
		getdata("dilip", "dilip");
		getdata(3, "hello");

		Printer<Integer> print = new Printer();
		print.show(22);
		Map<String, String> map = new HashMap<>();
		map.put("a", "dilip");
		map.put("a1", "dilip1");
		map.put("a2", "dilip2");
		map.put("a3", "dilip3");
		map.forEach((k, v) -> System.out.println(k + "\t" + v));
		// map.forEach(null);
		List<Integer> intList = Arrays.asList(10, 20, 30);
		// Demo.getdata3(intList);
		// or since we're inside same class:
		getdata3(intList);
		defactMehotd<String, Integer> myFunc = (k, v) -> System.out.println("Key: " + k + ", Value: " + v);
		// Call the abstract method
		myFunc.accept("A", 100);
		myFunc.accept("B", 200);
	}

	// generic method
	public static <T, V> void getdata7(T input, V input1) {
		System.out.println("output" + input);

	}

	// generic method
	public static <T, V> void getdata(T input, V input1) {
		System.out.println("output" + input);

	}

	// generic method with Return type
	public static <T, V> T getdata1(T input, V input1) {
		System.out.println("output" + input);
		return input;

	}

	// wild card method with generic list
	public static void getdata1(List<?> myList) {
		System.out.println("output" + myList);
		// return input;
	}

	// Bounded wild card method with
	// Upper bounded type
	// it can not take upper than integer
	public static void getdata3(List<? extends Integer> myList) {
		System.out.println("output" + myList);
		// return input;
	}

	// Bounded wild card method with (on ? value will be super class of Integer)
	// it could be Number.Obejct..
	// lower Bound, It can not take lower than Integer
	public static void getdata4(List<? super Integer> myList) {
		System.out.println("output" + myList);
		// return input;
	}

}

class Printer3<T, V> {
	T inputtype; // you can extend the interface type
	V inputtype1;

	public Printer3(T inputtype, V inputtype1) {
		this.inputtype = inputtype;
		this.inputtype1 = inputtype1;
	}

	public void show() {

	}
}

class Printer2<T extends Serializable & Cloneable> {
	T inputtype; // you can extend the interface type

	public void show() {

	}
}

@FunctionalInterface
interface defactMehotd<K, V> {

	void accept(K key, V value); // ✅ Abstract method (required)

	default void forEach(BiConsumer<? super K, ? super V> action) {
		action.accept(null, null); // example usage
	}
}

class Printer1<T extends Integer> {
	T inputtype; // all the method from Integer calls will be available with this variable
					// we are making it as a type of Integer
					// Bound generic upper bound

	public void show() {
		inputtype.shortValue();

	}
}

class Printer<T> {
	T inputtype; // this is generic type of variable can take any type

	public void show(T inputtype) {
		System.out.println(inputtype);

	}
}

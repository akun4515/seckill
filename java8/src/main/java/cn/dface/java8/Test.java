package cn.dface.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> list = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				list.add(apple);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

		List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
				.limit(3).collect(Collectors.toList());
		System.out.println(threeHighCaloricDishNames);

		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		System.out.println(wordLengths);
		
		menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
		
	}

	public void run(Runnable r) {
		r.run();
	}

	public void test() {
		this.run(() -> {
			System.out.println("this is something");
		});
	}

}

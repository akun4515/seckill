package cn.dface.java8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) { 
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
        this.type = type;
    }
	public enum Type { MEAT, FISH, OTHER }
}

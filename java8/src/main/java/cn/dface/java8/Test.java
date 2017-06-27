package cn.dface.java8;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
		List<Apple> list  = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if(p.test(apple)){
				list.add(apple);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		String s = "i just want to test what are you like to do";
		System.out.println(s);
	}
	
	public  void run(Runnable r){
		r.run();
	}
	
	public void test(){
		this.run(() -> {System.out.println("this is something");});
	}
}

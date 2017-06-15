package cn.dface.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
		DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
		DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
		demoAnnotationService.add();
		demoMethodService.add();
		context.close();
		
	}
}
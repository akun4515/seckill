package cn.dface.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
	
	@Action(name="add 注解拦截")
	public void add(){
		
	}
}

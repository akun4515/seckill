package cn.dface.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

public class UseFunctionService {
	@Autowired
	private FunctionService functionService;

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	public void use(){
		functionService.sayHello();
	}
}

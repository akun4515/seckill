package cn.dface.spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.dface.spring")
public class FunctionServiceConfig {
	
	@Bean
	public UseFunctionService usefuctionService(){
		return new UseFunctionService();
	}
	
	@Bean
	public FunctionService fuctionService(){
		return new FunctionService();
	}
}

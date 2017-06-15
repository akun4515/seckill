package cn.dface.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.dface.spring.aop")
@EnableAspectJAutoProxy
public class AspectConfig {

}

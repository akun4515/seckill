package cn.dface.spring.taskExecutor;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("cn.dface.spring.taskExecutor")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
	
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(5);
		pool.setMaxPoolSize(10);
		pool.setQueueCapacity(25);
		pool.initialize();
		return pool;
	}
	
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}

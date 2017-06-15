package cn.dface.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("接收到了消息"+msg);
	}

}

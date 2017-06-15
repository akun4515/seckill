package cn.dface.spring.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 2794126439297642929L;
	private String msg;
	
	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
	}
	
	
}

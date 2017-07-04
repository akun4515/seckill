package cn.dface.hightlight_springmvc4.bean;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JavaProcess {
	
	private String uid;
	private String pid;
	private String ppid;
	private String cpu;
	private String beginTime;
	private String time;
	private Map<String,String> params; 
}

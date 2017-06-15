package cn.dface.spring.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class DemoService {
	@Value(" what are you doing?")
	private String another;
	
}

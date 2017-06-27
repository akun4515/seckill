package cn.dface.hightlight_springmvc4;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SseController {
	
	@RequestMapping(value="/push",produces="text/event-stream;charset=UTF-8")
	public @ResponseBody String push(){
		Random r = new Random();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
	}
}
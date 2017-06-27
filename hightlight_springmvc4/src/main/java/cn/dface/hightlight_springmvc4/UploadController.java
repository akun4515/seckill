package cn.dface.hightlight_springmvc4;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile file){
		try {
			FileUtils.writeByteArrayToFile(new File("/Users/akun/"+file.getOriginalFilename()),file.getBytes());
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "wrong";
		}
		
	}
}

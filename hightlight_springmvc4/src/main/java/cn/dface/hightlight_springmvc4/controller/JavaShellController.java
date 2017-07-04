package cn.dface.hightlight_springmvc4.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;

import cn.dface.hightlight_springmvc4.bean.JavaProcess;
import cn.dface.hightlight_springmvc4.config.RmtShellExecutor;

@Controller
@RequestMapping("/api")
public class JavaShellController {
	@Autowired
	private RmtShellExecutor rmtShellExecutor;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public String getAll() {
		try {
			String str = rmtShellExecutor.exec("ps -ef | grep prague");
			return this.getJsonString(str);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getJsonString(String str) {

		String[] arr = str.split(" ");

		JavaProcess javaProcess = new JavaProcess();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < arr.length; i++) {
			String string = arr[i].trim();
			if (string.length() == 0) {
				continue;
			}

			map.put("param" + i, arr[i].trim());
		}
		javaProcess.setParams(map);
		String json = JSON.toJSONString(javaProcess);
		return json;
	}
}

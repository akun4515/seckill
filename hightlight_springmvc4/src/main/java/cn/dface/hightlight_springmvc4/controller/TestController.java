package cn.dface.hightlight_springmvc4.controller;

import cn.dface.hightlight_springmvc4.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akun on 2017/7/6.
 */
@RestController
@Api(description = "测试")
public class TestController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    @ApiOperation("test")
    public Object  get(){
        return "";
    }
}

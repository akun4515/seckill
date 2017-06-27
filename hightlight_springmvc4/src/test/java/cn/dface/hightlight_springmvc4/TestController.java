package cn.dface.hightlight_springmvc4;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cn.dface.hightlight_springmvc4.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyWebMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestController {
	
	private MockMvc  mockMvc;
	
	@Autowired
	private DemoService demoService;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	MockHttpSession  session;
	@Autowired
	MockHttpServletRequest  request;
	
	public MockHttpServletRequest get(String url){
		return new MockHttpServletRequest(null,null,url);
	}
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	public void testNormalController() throws Exception{
		
	}
}

package cn.dface.spring.test;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("cn.dface.spring")
@PropertySource("classpath:test.properties")
public class ElConfig {
	
	@Value("L love you Rachel")
	private String nomal;
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Value("#{demoService.another}")
	private String fromAhthor;
	
	@Value("classpath:test.txt")
	private Resource testFile;
	
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	public void outPutResource(){
		try {
			
			System.out.println(nomal);
			System.out.println(osName);
			System.out.println(fromAhthor);
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

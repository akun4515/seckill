package cn.dface.spring.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
	
	private String beanName;
	private ResourceLoader resourceLoader;
	
	public void setResourceLoader(ResourceLoader loader) {
		this.resourceLoader = loader;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public void ouputResult(){
		System.out.println("bean名称是"+beanName);
		Resource respurce = resourceLoader.getResource("classpath:test.txt");
		try {
			System.out.println("加载的文件内容是："+IOUtils.toString(respurce.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

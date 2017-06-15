package cn.dface.spring.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("cn.dface.spring.schedule")
@EnableScheduling
public class ScheduledConfig {

}

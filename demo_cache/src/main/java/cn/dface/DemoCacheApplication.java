package cn.dface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableCaching
public class DemoCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCacheApplication.class, args);
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(){
	    RedisTemplate<Object,Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }
}

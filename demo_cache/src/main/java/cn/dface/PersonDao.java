package cn.dface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by akun on 2017/7/10.
 */
@Repository
public class PersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    ValueOperations<String,String> valueOperations;
}

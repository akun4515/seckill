package cn.dface;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by akun on 2017/7/7.
 */
@ConfigurationProperties(prefix = "hello")
@Data
@Component
public class HelloServiceProperties {
    private static final  String MSG = "world";

    private String msg = MSG;

}

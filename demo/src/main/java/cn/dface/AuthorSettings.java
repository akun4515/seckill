package cn.dface;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by akun on 2017/7/7.
 */
@Component
@ConfigurationProperties(prefix = "author")
@Data
public class AuthorSettings {
    private String name;
    private Long   age;
}

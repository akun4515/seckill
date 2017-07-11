package cn.dface;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by akun on 2017/7/7.
 */
@Data
public class HelloService {

    private String msg;

    public String sayHello(){
        return "hello" + msg;
    }
}

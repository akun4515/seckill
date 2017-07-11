package cn.dface;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Created by akun on 2017/7/11.
 */
@Data
public class Person {
    @Size(max=4,min=2)
    private String name;
    private Integer age;
    private String  nation;
    private String  address;
}

package cn.dface;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by akun on 2017/7/11.
 */
@Entity
@Data
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}

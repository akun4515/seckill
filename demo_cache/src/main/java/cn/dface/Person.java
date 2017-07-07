package cn.dface;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by akun on 2017/7/7.
 */
@Entity
@Data
@ToString
public class Person implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;
}

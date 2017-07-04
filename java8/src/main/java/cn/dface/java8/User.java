package cn.dface.java8;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	private Integer sid;
	private String name;
	private Integer age;
	private Integer gender;
}

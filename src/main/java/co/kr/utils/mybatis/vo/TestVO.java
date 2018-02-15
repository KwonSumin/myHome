package co.kr.utils.mybatis.vo;

import java.lang.reflect.Field;
import java.util.List;

public class TestVO extends AbstractConvertVO{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

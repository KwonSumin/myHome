package co.kr.utils.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import co.kr.myhome.login.UserVO;
public class ReflectUtil {
	
	public static void main(String[] args) throws Exception {
	}
	
	public static Field[] getFields(Object obj) throws Exception {
		Field[] result = obj.getClass().getDeclaredFields();	
		return result;
	}
	public static void iteratorFiled(Object obj,Map arg ) throws Exception{
		Field[] fields = getFields(obj);
		Function fun = a -> {
			System.out.println(a);
			return a;
		};
		fun.apply("test");
	}
	 
}

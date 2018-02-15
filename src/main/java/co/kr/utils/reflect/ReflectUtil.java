package co.kr.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import co.kr.myhome.command.vo.CommandVO;
import co.kr.myhome.login.UserVO;
public class ReflectUtil {
	
	public static void main(String[] args) throws Exception {

		Object target = new CommandVO();
		String methodName = "test";
		Integer[] parameter = new Integer[]{1,2};
		Object result = ReflectUtil.execute(target, methodName, parameter);
		System.out.println(result);
		
	}
	
	public static Field[] getFields(Object obj) throws Exception {
		Field[] result = obj.getClass().getDeclaredFields();	
		return result;
	}
	public static ArrayList<Field> filter(Object obj,Predicate pred) throws Exception{
		Field[] fields = getFields(obj);
		ArrayList result = new ArrayList();
		for(int i=0; i<fields.length; i++) {
			if(pred.test(fields[i])) {
				result.add(fields[i]);
			}
		}
		return result;
	}
	
	public Integer test(Integer n,Integer n2) {return n+n2;}
	
	public static Object execute(Object target,String methodName,Object[] parameter) throws Exception{
		Object result = null;
		Method[] methods = target.getClass().getDeclaredMethods();
		
		for(int i=0; i<methods.length; i++) {
			Method targetMethod = methods[i];
			if( methodName.equals(targetMethod.getName()) ) {
				result = targetMethod.invoke(target, parameter);
			}
		}
		return result;
	}
}

package co.kr.myhome.common.vo;

import java.lang.reflect.Field;

import com.google.gson.Gson;

import co.kr.utils.reflect.ReflectUtil;

public abstract class AbstracCommonVO {
	public String toJson()  throws Exception {
		return new Gson().toJson(this);
	}

	@Override
	public String toString() {
		String result = "";
		try{
			Field[] fields =ReflectUtil.getFields(this);
			int idx = fields.length;
			String str = "";
			String[] names = new String[idx];
			String[] values = new String[idx];
			for( int i=0; i<fields.length; i++) {
				fields[i].setAccessible(true);
				names[i] = fields[i].getName();
				str += fields[i].getName() + " : %s";
				values[i] = fields[i].get(this).toString();
				
				if(i != fields.length-1) {
					str += ", ";
				}
				
			}
			result = String.format(str, values) + "\n";
		}catch(Exception e) {}
		return result;
	}
	
}

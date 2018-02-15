package co.kr.utils.mybatis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.function.Predicate;

import co.kr.utils.reflect.ReflectUtil;

public abstract class AbstractConvertVO {
	protected ArrayList<String> names;
	protected ArrayList<Object> values;
	
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	public ArrayList<Object> getValues() {
		return values;
	}
	public void setValues(ArrayList<Object> values) {
		this.values = values;
	}
	public void setNotNullFields() throws Exception {
		ArrayList<Field> list = getNotNullFields();
		this.names = new ArrayList();
		this.values = new ArrayList();
		for( int i=0; i<list.size(); i++) {
			names.add(list.get(i).getName());
			values.add(list.get(i).get(this));
		}
		
	}
	private ArrayList getNotNullFields() throws Exception {
		ArrayList list = new ArrayList();
		Field[] fields = ReflectUtil.getFields(this);
		Predicate isNotNull = (a)-> {
			try{
				Field field = (Field)a;
				field.setAccessible(true);
				return !isEmpty(field.get(this));
			} catch (Exception e) {			
				return false;
			}
		};
		list = ReflectUtil.filter(this, isNotNull);
		
		return list;
	}
	private boolean isEmpty(Object obj){
		if( obj instanceof Integer ) {
			if( (Integer)obj == 0 ) return true;
		}
		return obj ==null;
	}
}

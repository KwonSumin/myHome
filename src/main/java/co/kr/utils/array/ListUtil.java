package co.kr.utils.array;

import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListUtil {
	
	public static <T> T get(List<T> list,Predicate<T> pred) throws Exception {
		Iterator<T> iter = list.iterator();
		while(iter.hasNext()) {
			T tmp = iter.next();
			if( pred.test(tmp) ) return tmp;
		}
		return null;
	}
	public static <T,E> T get(List<T> list,BiPredicate<T,E> pred,E param) throws Exception {
		Iterator<T> iter = list.iterator();
		while(iter.hasNext()) {
			T tmp = iter.next();
			if( pred.test(tmp,param) ) return tmp;
		}
		return null;
	}
	
}

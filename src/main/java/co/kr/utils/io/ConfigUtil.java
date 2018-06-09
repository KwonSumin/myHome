package co.kr.utils.io;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

public class ConfigUtil {
	public static void main(String[] args) throws Exception{
		HashMap data = new HashMap();
		data.put("name","t");
		data.put("age", "t1");
		
		ConfigUtil.writeConfig("test", data, new File("C:/test/test.ini"));
		
		
	}
	
	public static void writeConfig(String section,Map<String, String> data,File file) throws Exception{
		
		Ini config = new Ini();
		config.load(file);
		config.setFile(file);
		Section sc = config.get(section);
		if( sc == null ) {
			sc = config.add(section);
		}
		Iterator keys = data.keySet().iterator();
		while( keys.hasNext() ) {
			String key = keys.next().toString();
			String value = data.get(key);
			System.out.println(value);
			sc.put(key, value);
		}
		config.store();
	}
}

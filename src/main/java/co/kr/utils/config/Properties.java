package co.kr.utils.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public class Properties implements Serializable{
	
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		File file = new File("c:/test/test.properties");
		p.load(new FileInputStream(file));
		p.put("selection", "name", "sumin");
		p.put("selection", "name", "sumin123");
		System.out.println(p.serialize("selection"));
	}
	
	private HashMap<String,HashMap<String, String>> selections;

	public Properties() {
		super();
		this.selections = new HashMap<String,HashMap<String, String>>();
	}
	
	public void addSelection(String name){
		if( selections.get(name) != null ) return;
		selections.put(name, new HashMap<String, String>());
	}
	
	public HashMap<String, String> getSelection(String name){
		return selections.get(name);
	}
	
	public void setSelection(String name,HashMap<String, String> map) {
		selections.put(name, map);
	}
	public void put(String selection,String key,String value) {
		selections.get(selection).put(key,value);
	}
	public String get(String selection,String key) {
		return selections.get(selection).get(key);
	}
	
	public void load(InputStream in) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String tmp;
		String current = "";
		while( (tmp = reader.readLine()) != null ) {
			if(tmp.indexOf("[") == 0 && tmp.indexOf("]") != -1) {
				tmp = tmp.replace("[", "");
				tmp = tmp.replace("]", "");
				current = tmp;
				addSelection(current);
				
			} else {
				String key = tmp.replaceFirst("=.*", "").trim();
				String value = tmp.replaceFirst(".*=", "").trim();
				selections.get(current).put(key, value);
				/*
				System.out.println(key);
				System.out.println(value);
				System.out.println(current);
				*/
			}
			
		}
	}
	
	public String serialize(String selectionName) {
		String serialize = "";
		
		Iterator<String> keys = selections.get(selectionName).keySet().iterator();
		
		while( keys.hasNext() ) {
			String key = keys.next();
			String value = selections.get(selectionName).get(key);
			
			if(serialize.equals("")) {
				serialize += key + "=" + value; 
			} else {
				serialize += "&" + key + "=" + value; 
			}
		}
		
		return serialize;
	}
	
	public void save(File file) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		Iterator<String> sIter = selections.keySet().iterator();
		while( sIter.hasNext() ) {
			String selectionName = sIter.next();
			HashMap<String, String> selection = selections.get(selectionName);
			Iterator<String> cnfIter = selection.keySet().iterator();
			
			writer.write("["+selectionName+"]");
			writer.write("\r\n");
			
			while( cnfIter.hasNext() ) {
				
				String key = cnfIter.next();
				String value = selection.get(key);
				writer.write(key + " = " + value);
				writer.write("\r\n");
			}
		}
		writer.flush();
	}
}

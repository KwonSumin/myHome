package co.kr.myhome.sleep;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.apache.commons.collections.iterators.ArrayListIterator;

import co.kr.myhome.command.base.CommandService;
import co.kr.myhome.sleep.vo.PortStateVO;
import co.kr.utils.array.ListUtil;
import co.kr.utils.process.ProcessUtil;

public class CheckPortSvc {
	
	public static void main(String[] args) {
		
		System.out.println(new CheckPortSvc().getState("192.168.0.2:8080"));
		
	}
	
	
	public String getState(String ip){
		String state = "";
		
		ArrayList<PortStateVO> list = getPortState();
		BiPredicate<PortStateVO,String> pred = (vo,test) -> {
			
			String inIP = vo.getInIP();
			
			if( inIP.equals(test) ) return true;
			
			return false;
		};
		try{
			PortStateVO vo = ListUtil.get(list, pred, ip);
			state = vo != null ? vo.getState() : null;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return state;
	}
	
	private ArrayList<PortStateVO> getPortState(){
		ArrayList<PortStateVO> list = new ArrayList();
		try{
			Process p = ProcessUtil.getProcess("netstat -ano");
			BufferedReader reader = ProcessUtil.getReader(p);
			
			String tmp;
			
			
			while( (tmp = reader.readLine()) != null ) {
				if( tmp.matches(".*(UDP|TCP).*") ) {
					tmp = tmp.replaceAll("\\s+", " ");
					PortStateVO vo = new PortStateVO(tmp);
					list.add(vo);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
}

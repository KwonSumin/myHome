package co.kr.myhome.sleep;

import java.io.BufferedReader;
import java.util.ArrayList;

import co.kr.myhome.command.base.CommandService;
import co.kr.myhome.sleep.vo.PortStateVO;
import co.kr.utils.process.ProcessUtil;

public class CheckPortSvc {
	
	public static void main(String[] args) {
		
		new CheckPortSvc().getPortState();
		
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
			
			System.out.println(list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
}

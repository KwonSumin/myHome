package co.kr.myhome.ticket;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import co.kr.utils.https.URLConnectionUtil;

@Controller
public class ticketCtrl {
	
	@Autowired
	LinkService linkService;
	
	@RequestMapping(value="/ticketLink/index")
	public ModelAndView torrent(){
		return new ModelAndView("/ticket/ticketLink");
	}
	
	@RequestMapping(value="/ticketLink/setting.do")
	public ModelAndView setting(@RequestParam Map data) throws Exception{
		System.out.println("setting");
		if( data.get("select_seat") != null && !data.get("select_seat").equals("") ) {
			data.put("seat_auto", data.get("select_seat"));
		}
		
		System.out.println(data);
		linkService.writeConfig(data);
		
		return new ModelAndView("redirect:/login");
	}
	
	
}

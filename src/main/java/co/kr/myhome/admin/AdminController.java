package co.kr.myhome.admin;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.myhome.command.service.MediaCommandService;
import co.kr.myhome.common.vo.AgentProcessService;
import co.kr.utils.request.ParamUtil;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin/command")
	public ModelAndView command(){
		ModelAndView mav = new ModelAndView("admin/command");
		return mav;
	}
	
	
	public boolean isAddmin() {
		
		return true;
	}
}

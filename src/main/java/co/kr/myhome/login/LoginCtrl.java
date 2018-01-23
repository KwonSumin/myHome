package co.kr.myhome.login;

import java.lang.reflect.Field;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import co.kr.utils.reflect.ReflectUtil;


@Controller
public class LoginCtrl {
	private final static Logger logger = LoggerFactory.getLogger(LoginCtrl.class);
	
	public static void main(String[] args) {
		logger.info("test");
		
	}
	@Autowired
	LoginService loginService;
	@RequestMapping(value="/login")
	public ModelAndView login() throws Exception{
		return new ModelAndView("/user/login");
	}
	
	@RequestMapping(value="/login/login.do",method= RequestMethod.POST)
	public ModelAndView doLogin(String user_id,String password,HttpServletRequest request)
	 throws Exception{
		ModelAndView mav = new ModelAndView("/");
		System.out.println("login.do");
		HttpSession session = getSession(request);
		UserVO vo = new UserVO();
		if ( loginService.hasUser(user_id, password) ){
			vo.setUser_id(user_id);
			
			System.out.println("session user_id : "+session.getAttribute("user_id"));
		} else {
			
		}
		doWriteLogin(session, vo);
		return mav;
	}
	private void doWriteLogin(HttpSession session,UserVO vo) throws Exception{
		HashMap arg = new HashMap();
		arg.put("vo", vo);
		ReflectUtil.iteratorFiled(vo, arg);
	}
	
	private HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
}

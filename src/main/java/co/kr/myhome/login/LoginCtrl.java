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
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView doLogin(UserVO vo,HttpServletRequest request)
	 throws Exception{
		ModelAndView mav = new ModelAndView("/user/login");
		System.out.println("login.do");
		HttpSession session = getSession(request);
		if ( loginService.hasUser(vo) ){
			session.setAttribute("id", vo.getUser_id());
			System.out.println("session user_id : "+session.getAttribute("id"));
		}
		System.out.println(session.getAttribute("id"));
		return mav;
	}
	
	@RequestMapping(value="/login/memberJoin")
	public ModelAndView memberJoin(UserVO vo) throws Exception{
		return new ModelAndView("/user/memberJoin");
	}
	
	@RequestMapping(value="/login/memberJoin.do")
	public ModelAndView doMemberJoin(UserVO vo) throws Exception{
		ModelAndView mav = new ModelAndView("/user/memberJoin");
		System.out.println(vo);
		loginService.memberJoin(vo);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/login/check.do")
	public String check(HttpServletRequest request) throws Exception{
		String result = (String) getSession(request).getAttribute("id");
		return result;
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

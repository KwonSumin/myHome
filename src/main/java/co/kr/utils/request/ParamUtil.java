package co.kr.utils.request;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//¹Ì±¸Çö
@Deprecated
public class ParamUtil {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Serializable vo;
	
	public ParamUtil() {
		super();
	}

	public ParamUtil(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}
	
}

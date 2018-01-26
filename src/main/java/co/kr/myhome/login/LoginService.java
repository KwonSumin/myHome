package co.kr.myhome.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.myhome.common.CommonDAO;
import co.kr.utils.security.SHA256Util;

@Service
public class LoginService {
	
	
	
	public LoginService() {
		super();
		System.out.println("»ý¼º");
	}

	@Autowired
	CommonDAO commonDAO;
	
	public boolean hasUser(UserVO vo){
		try{
			int result = (Integer)commonDAO.selectOne("co.kr.myhome.user.hasUser",vo);
			if(result == 1) return true;
		} catch(Exception e){
			return false;
		}
		return false;
	}
	
	public boolean memberJoin(UserVO vo) throws Exception{
		//commonDAO.selectOne("co.kr.myhome.user.join",vo);
		return true;
	}
}

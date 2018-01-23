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
	
	public boolean hasUser(String user_id,String password){
		try{
			UserVO vo = new UserVO();
			vo.setUser_id(user_id);
			vo.setPassword(SHA256Util.getEncryption(password));
			commonDAO.selectOne("co.kr.myhome.user.hasUser",vo);
		} catch(Exception e){
			return false;
		}
		return true;
	}
}

package co.kr.myhome.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.myhome.command.vo.CommandVO;
import co.kr.myhome.common.CommonDAO;

@Service
public class ManageCommandService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	public String addCommand(CommandVO vo){
		try{
			commonDAO.insert("",vo);
			return "S:�߰� ����";
		} catch(Exception e) {
			return "E:���� �Ͽ����ϴ�.";
		}
	}
	
}

package co.kr.myhome.ticket;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Service;

import co.kr.utils.io.ConfigUtil;

@Service
public class LinkService {
	public void writeConfig(Map data) throws Exception {
		File file = new File("D:/dev/myhome/python/자동예매/ticketlink/config/info.properties");
		ConfigUtil.writeConfig("user", data, file);
	}
}

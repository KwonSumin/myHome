package co.kr.myhome.torrent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import co.kr.utils.https.URLConnectionUtil;

@Controller
public class TorrentCtrl {
	
	@Autowired
	TorrentService torrentSvc;
	
	
	@RequestMapping(value="/torrent/index")
	public ModelAndView torrent(){
		return new ModelAndView("/torrent/torrent");
	}
	
	@ResponseBody
	@RequestMapping(value="/torrent/search.do",produces="application/json; charset=UTF-8")
	public String search(String search) throws Exception{
		ArrayList<TorrentVO> list = torrentSvc.searchTorrent(search);
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/torrent/download.do")
	public void downloadOnserver(TorrentVO vo) throws Exception{
		Properties properties = new Properties();
		InputStream in = getClass().getResourceAsStream("/properties/torrent.properties");
		properties.load(in);
		String fileURL = "https://torrentkim12.com/bbs/download.php?bo_table="+vo.getCategory()+"&wr_id="+vo.getDownId()+"&no=0";
		String saveDir = properties.getProperty("torrentDown");
		System.out.println("download : " + fileURL);
		URLConnectionUtil.downloadFile(fileURL, saveDir, vo.getTitle());
	}
	
}

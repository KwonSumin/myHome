package co.kr.myhome.torrent;

import java.util.ArrayList;

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
		String fileURL = "https://torrentkim12.com/bbs/download.php?bo_table=torrent_variety&wr_id="+vo.getDownId()+"&no=0";
		String saveDir = "C:/test/test";
		URLConnectionUtil.downloadFile(fileURL, saveDir, vo.getTitle());
	}
	
}

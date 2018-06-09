package co.kr.myhome.torrent;

import java.util.ArrayList;
import java.util.Properties;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import co.kr.utils.https.URLConnectionUtil;
import co.kr.utils.parser.html.HTMLParserUtil;

@Service("torrentSvc")
public class TorrentService {
	
	public static void main(String[] args) throws Exception {
		System.out.println(searchTorrent("무한도전"));
	}
	
	public static ArrayList<TorrentVO> searchTorrent(String search) throws Exception{
		ArrayList<TorrentVO> result = new ArrayList();

		String rootPath = "https://torrentkim.pro/bbs/s.php";
		String query = "?k=" + search + "&b=&q=";
		String url = rootPath + query;
		Document doc = HTMLParserUtil.getDocument(url);
		Elements elements = doc.select("a[target=s]");
		Elements hits = doc.select("td.hit");
		for(int i=0; i<elements.size(); i++) {
			String[] href = elements.get(i).attr("href").split("/");
			
			String id = href[href.length-1].replaceAll(".html", ""); //id값 파싱
			String size = hits.get(i+1).html();
			String category = href[1];
			result.add(new TorrentVO(elements.get(i).html(),id,size,category)); // 제목,id값
		}
		return result;
	}
}

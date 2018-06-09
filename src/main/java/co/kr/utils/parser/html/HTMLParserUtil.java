package co.kr.utils.parser.html;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * lib : jsoup
 */

public class HTMLParserUtil {
	
	public static void main(String[] args) throws Exception {
		
		//Document doc = getDocument("https://apply.lh.or.kr/LH/index.html?gv_url=SIL::CLCC_SIL_0030.xfdl&gv_menuId=1010202&gv_param=LCC:Y,TAB_PAGE:2,UPP_AIS_TP_CD:05#MN::CLCC_MN_0010:");
		Document doc = getDocument("https://torrentkim.pro/bbs/s.php?k=%EB%AC%B4%ED%95%9C%EB%8F%84%EC%A0%84&b=&q=");
		
		System.out.println(doc.html());
	}
	
	public static Document getDocument(String url) throws IOException{
		//userAgent ������ 403���� ��°�� ������ �߰�
		String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36";
		return Jsoup.connect(url).userAgent(userAgent).get();
	}
	
	public static String getHTML(Document doc){
		String result = "";
		
		
		return result;
	}
	
	
}

package co.kr.utils.parser.html;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * lib : jsoup
 */

public class HTMLParserUtil {
	
	public static void main(String[] args) throws Exception {
		
		Document doc = getDocument("https://torrentkim12.com/");
		
		System.out.println(doc.html());
	}
	
	public static Document getDocument(String url) throws IOException{
		//userAgent 없을시 403에러 뱉는경우 때문에 추가
		String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36";
		return Jsoup.connect(url).userAgent(userAgent).get();
	}
	
	public static String getHTML(Document doc){
		String result = "";
		
		
		return result;
	}
	
	
}

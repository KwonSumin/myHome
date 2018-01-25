package co.kr.utils.https;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

import javax.net.ssl.HttpsURLConnection;
 
/**
 * A utility that downloads a file from a URL.
 * @author www.codejava.net
 *
 */
public class URLConnectionUtil {
    private static final int BUFFER_SIZE = 4096;
 
    /**
     * Downloads a file from a URL
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
		//String url = "https://torrentkim12.com/bbs/download.php?bo_table=torrent_variety&wr_id=853422&no=0";
		//downloadFile(url,"c:/test/test","아는형님.torrent");
		
    	getHttpsConnection("https://apply.lh.or.kr/lhCmcNoSessionAdapter.lh?serviceID=OCMC_LCC_SIL_SILSNOT_L0001","https");
    	
	}
    
    public static URLConnection setDefaultHeaders(URLConnection conn){
        //헤더값 추가 ( 해더값 없을시 403에러 내뱉는 사이트 있음)
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Charset", "windows-949,utf-8;q=0.7,*;q=0.3");
        conn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
        conn.setRequestProperty("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.75 Safari/535.7");
        conn.setRequestProperty("Cache-Control", "no-cache, no-store");
        return conn;
    }
    
    public static void writeBody(URLConnection conn,String str) throws Exception{
    	conn.setDoOutput(true);
    	OutputStream out = conn.getOutputStream();
    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
    	writer.write(str);
    }
    public static BufferedReader getReader(URLConnection conn) throws Exception {
    	InputStream in = conn.getInputStream();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    	return reader;
    }
    public static URLConnection getHttpsConnection(String urlStr,String protocol)
        throws IOException, Exception {
        URL url = new URL(urlStr);
        URLConnection conn = null;
        if( protocol.equalsIgnoreCase("https"))  {
        	conn = ( HttpsURLConnection )url.openConnection();
        } else if( protocol.equalsIgnoreCase("http") ){
        	conn = ( HttpURLConnection )url.openConnection();
        } else {
        	throw new Exception("http,https만가능합니다.");
        }
        return conn;
    }
    
    public static void downloadFile(String fileURL, String saveDir,String fileName)
            throws IOException {
        URL url = new URL(fileURL);
        HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
        
        //헤더값 추가 ( 해더값 없을시 403에러 내뱉는 사이트 있음)
        httpsConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpsConn.setRequestProperty("Accept-Charset", "windows-949,utf-8;q=0.7,*;q=0.3");
        httpsConn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
        httpsConn.setRequestProperty("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
        httpsConn.setRequestProperty("Connection", "keep-alive");
        httpsConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.75 Safari/535.7");

        
        int responseCode = httpsConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String disposition = httpsConn.getHeaderField("Content-Disposition");
            String contentType = httpsConn.getContentType();
            int contentLength = httpsConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
            	/*
                if (index > 0) {
                    fileName = URLDecoder.decode(disposition.substring(index + 10,
                            disposition.length() - 1));
                }
                */
            } else {
                // extracts file name from URL
                /*
            	fileName = URLDecoder.decode(fileURL.substring(fileURL.lastIndexOf("/") + 1,
            			fileURL.length()));
            	*/
            }
            
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
            
            // opens input stream from the HTTP connection
            InputStream inputStream = httpsConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpsConn.disconnect();
    }
}
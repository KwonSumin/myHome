package co.kr.utils.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ProcessUtil {
	
	public static Process getProcess(String cmd)throws Exception {
		return Runtime.getRuntime().exec(cmd);
	}
	
	public static BufferedWriter getWriter(Process p){
		OutputStream out = p.getOutputStream();
		return new BufferedWriter(new OutputStreamWriter(out));
	}
	public static BufferedReader getReader(Process p ){
		InputStream in = p.getInputStream();
		return new BufferedReader(new InputStreamReader(in));
	}
	public static BufferedReader getErrorReader(Process p){
		InputStream in = p.getErrorStream();
		return new BufferedReader(new InputStreamReader(in));
	}
}

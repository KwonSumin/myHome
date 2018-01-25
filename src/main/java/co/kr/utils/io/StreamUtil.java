package co.kr.utils.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamUtil {
	public static BufferedReader getReader(File file) throws Exception{
		FileInputStream in = new FileInputStream(file);
		return new BufferedReader(new InputStreamReader(in));
	}
	public static BufferedWriter getWriter(File file) throws Exception {
		FileOutputStream out = new FileOutputStream(file);
		return new BufferedWriter(new OutputStreamWriter(out));
	}
	public static BufferedReader getReader(InputStream in ) throws Exception{
		return new BufferedReader(new InputStreamReader(in));
	}
	public static BufferedWriter getWriter(OutputStream out) throws Exception {
		return new BufferedWriter(new OutputStreamWriter(out));
	}
}

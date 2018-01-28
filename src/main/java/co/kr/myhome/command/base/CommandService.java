package co.kr.myhome.command.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import co.kr.utils.process.ProcessUtil;

public abstract class CommandService {
	private final String script;
	public CommandService(String svc) throws Exception{
		super();
		Properties properties = new Properties();
		InputStream fileIn = getClass().getResourceAsStream("/properties/command.properties");
		properties.load(fileIn);
		String script = properties.getProperty("autohotkey");
		this.script = script+"/"+svc;
	}
	
	public void command(String cmd) throws Exception {
		String command = this.script + "/" + cmd;
		Process p = ProcessUtil.getProcess(command);
	}
	
}

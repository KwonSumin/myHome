package co.kr.myhome.common.vo;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import co.kr.utils.reflect.ReflectUtil;

public class AgentProcessService {
	private String message;
	private Object result;
	private Exception error;
	private final Properties errorProperties = new Properties();
	
	
	public AgentProcessService() throws Exception {
		super();
		errorProperties.load(new InputStreamReader(
			getClass().getResourceAsStream("/properties/errorMEssage.properties"), "UTF-8")
		);
	}

	public void requestProcess(Object target,String methodName,Object[] parameter,String successMessage){
		this.setMessage(successMessage);
		try{
			this.result = ReflectUtil.execute(target, methodName, parameter);
		}catch(Exception e){
			this.error = e;
			this.message = getErrorMessage(e);
		}
	}
	public String getErrorMessage(Exception e){
		if( e instanceof SQLException ) {
			return (String)this.errorProperties.get("sqlError");
		}
		return "E:[E9999]알수없는 에러 입니다.";
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}

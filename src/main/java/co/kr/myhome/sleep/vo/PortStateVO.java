package co.kr.myhome.sleep.vo;

public class PortStateVO {
	private String protocol;
	private String inIP;
	private String outIP;
	private String state;
	
	public PortStateVO(String state) {
		super();
		String[] arr = state.split(" ");
		setProtocol(arr[1]);
		setInIP(arr[2]);
		setOutIP(arr[3]);
		if( arr.length==6 ) {
			setState(arr[4]);
		}
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getInIP() {
		return inIP;
	}
	public void setInIP(String inIP) {
		this.inIP = inIP;
	}
	public String getOutIP() {
		return outIP;
	}
	public void setOutIP(String outIP) {
		this.outIP = outIP;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "PortStateVO [protocol=" + protocol + ", inIP=" + inIP + ", outIP=" + outIP + ", state=" + state + "]\n";
	}
}

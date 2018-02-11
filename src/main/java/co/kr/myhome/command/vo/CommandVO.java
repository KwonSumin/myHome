package co.kr.myhome.command.vo;

public class CommandVO {
	private int seq;
	private String name;
	private String path;
	private String insert_dt;
	private String update_dt;
	private String del_yn;
	private String descript;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getInsert_dt() {
		return insert_dt;
	}
	public void setInsert_dt(String insert_dt) {
		this.insert_dt = insert_dt;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	@Override
	public String toString() {
		return "CommandVO [seq=" + seq + ", name=" + name + ", path=" + path + ", insert_dt=" + insert_dt
				+ ", update_dt=" + update_dt + ", del_yn=" + del_yn + ", descript=" + descript + "]";
	}
	
	public int test(int n,int n2){return n+n2;}
	
}

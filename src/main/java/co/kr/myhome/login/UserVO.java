package co.kr.myhome.login;

import co.kr.utils.security.SHA256Util;

public class UserVO {
	private Integer seq;
	private String user_id;
	private String password;
	private String user_group;
	private String name;
	private String email;
	private String phone;
	private String insert_dt;
	private String update_dt;
	private String del_yn;
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws Exception{
		this.password = SHA256Util.getEncryption(password);
	}
	public String getUser_group() {
		return user_group;
	}
	public void setUser_group(String user_group) {
		this.user_group = user_group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	@Override
	public String toString() {
		return "UserVO [seq=" + seq + ", user_id=" + user_id + ", password=" + password + ", user_group=" + user_group
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", insert_dt=" + insert_dt
				+ ", update_dt=" + update_dt + ", del_yn=" + del_yn + "]";
	}
	
	
}

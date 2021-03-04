package cn.cloud.entity;

import java.util.Date;

public class User {
	private Integer uid;
	private String uname;
	private String username;
	private String password;
	private String email;
	private Integer status;
	private Date create_time;
	
	public User() {
		super();
	}
	//注册用户时，用到的构造方法
	public User(String uname, String username, String password, String email, Date create_time) {
		super();
		this.uname = uname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.create_time = create_time;
	}
	//用户登录时，用到的构造方法
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", status=" + status + ", create_time=" + create_time + "]";
	}
	
}

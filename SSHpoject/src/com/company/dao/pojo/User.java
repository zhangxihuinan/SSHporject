package com.company.dao.pojo;


public class User extends Detail{
	private int uid;
	private String username;
	private String password;
	private String priority;
	private String adddate;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String username, String password, String priority, String adddate) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.priority = priority;
		this.adddate = adddate;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String priority) {
		super();
		this.username = username;
		this.password = password;
		this.priority = priority;
	}
	public User(String username, String password, String priority, String adddate) {
		super();
		this.username = username;
		this.password = password;
		this.priority = priority;
		this.adddate = adddate;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", priority=" + priority
				+ ", adddate=" + adddate + "]";
	}
	
	
	
}

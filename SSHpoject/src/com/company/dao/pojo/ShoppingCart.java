package com.company.dao.pojo;

import java.util.Date;

public class ShoppingCart {
	private int sid;
	private int uid;
	private int gid;
	private Date adddate;
	private int checkbox;
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ShoppingCart(int sid, int uid, int gid, Date adddate, int checkbox) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.gid = gid;
		this.adddate = adddate;
		this.checkbox = checkbox;
	}

	public ShoppingCart(int sid, int uid, int gid, Date adddate) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.gid = gid;
		this.adddate = adddate;
	}
	public ShoppingCart(int uid, int gid, Date adddate) {
		super();
		this.uid = uid;
		this.gid = gid;
		this.adddate = adddate;
	}
	
	
	public int getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(int checkbox) {
		this.checkbox = checkbox;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}



	@Override
	public String toString() {
		return "ShoppingCart [sid=" + sid + ", uid=" + uid + ", gid=" + gid + ", adddate=" + adddate + ", checkbox="
				+ checkbox + "]";
	}
	
	
}

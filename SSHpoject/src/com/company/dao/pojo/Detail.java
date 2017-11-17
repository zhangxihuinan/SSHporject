package com.company.dao.pojo;

import java.util.Date;

public class Detail {
	private int uid;
	private String realname;
	private String sex;
	private int phone;
	private Date birthday;
	private String sqlbirthday;
	private String filePath;

	public Detail() {
		// TODO Auto-generated constructor stub
	}

	public Detail(int uid, String realname, String sex, int phone, Date birthday, String filePath) {
		super();
		this.uid = uid;
		this.realname = realname;
		this.sex = sex;
		this.phone = phone;
		this.birthday = birthday;
		this.filePath = filePath;
	}

	public Detail(String realname, String sex, int phone, Date birthday) {
		super();
		this.realname = realname;
		this.sex = sex;
		this.phone = phone;
		this.birthday = birthday;
	}

	public Detail(String realname, String sex, int phone, String sqlbirthday, String filePath) {
		super();
		this.realname = realname;
		this.sex = sex;
		this.phone = phone;
		this.sqlbirthday = sqlbirthday;
		this.filePath = filePath;
	}

	public Detail(int uid, String realname, String sex, int phone, String sqlbirthday, String filePath) {
		super();
		this.uid = uid;
		this.realname = realname;
		this.sex = sex;
		this.phone = phone;
		this.sqlbirthday = sqlbirthday;
		this.filePath = filePath;
	}

	public String getSqlbirthday() {
		return sqlbirthday;
	}

	public void setSqlbirthday(String sqlbirthday) {
		this.sqlbirthday = sqlbirthday;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Detail [uid=" + uid + ", realname=" + realname + ", sex=" + sex + ", phone=" + phone + ", birthday="
				+ sqlbirthday + ", filePath=" + filePath + "]";
	}

}

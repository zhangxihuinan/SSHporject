package com.company.dao.pojo;


public class Goods {
	private int gid;
	private String gname;
	private String maker;
	private double price;
	private String filePath;
	private String gtype;
	
	
	private int sid;//表中没有  仅用于数据封装
	private String checkbox;//表中没有  仅用于数据封装
	private int quantity;//表中没有  仅用于数据封装
	private String nowcount;//表中没有  仅用于数据封装
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Goods(int gid, String gname, String maker, double price, String filePath, String gtype, int sid,
			String checkbox, int quantity,String nowcount) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.maker = maker;
		this.price = price;
		this.filePath = filePath;
		this.gtype = gtype;
		this.sid = sid;
		this.checkbox = checkbox;
		this.quantity = quantity;
		this.nowcount = nowcount;
	}



	public Goods(int gid, String gname, String maker, double price, String filePath, String gtype, int sid,
			String checkbox) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.maker = maker;
		this.price = price;
		this.filePath = filePath;
		this.gtype = gtype;
		this.sid = sid;
		this.checkbox = checkbox;
	}


	public Goods(int gid, String gname, String maker, double price, String filePath, String gtype, int sid) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.maker = maker;
		this.price = price;
		this.filePath = filePath;
		this.gtype = gtype;
		this.sid = sid;
	}

	public Goods(int gid, String gname, String maker, double price, String filePath, String gtype) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.maker = maker;
		this.price = price;
		this.filePath = filePath;
		this.gtype = gtype;
	}
	public Goods(String gname, String maker, double price, String filePath, String gtype) {
		super();
		this.gname = gname;
		this.maker = maker;
		this.price = price;
		this.filePath = filePath;
		this.gtype = gtype;
	}
	
	public Goods(String gname, String maker, double price, String gtype) {
		super();
		this.gname = gname;
		this.maker = maker;
		this.price = price;
		this.gtype = gtype;
	}
	
	public String getNowcount() {
		return nowcount;
	}



	public void setNowcount(String nowcount) {
		this.nowcount = nowcount;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getGtype() {
		return gtype;
	}
	public void setGtype(String gtype) {
		this.gtype = gtype;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", maker=" + maker + ", price=" + price + ", filePath="
				+ filePath + ", gtype=" + gtype + "]";
	}
	
}

package com.company.dao.pojo;

public class Order {
	private int oid;
	private String orderdate;//下单时间作为主键
	private int uid;//用户ID
	private int gid;//商品ID
	private int quantity;//购买数量
	private double allcount;//订单总价
	private String receive;//收货地址
	
	public Order() {
		// TODO Auto-generated constructor stub
	}



	public Order(int oid, String orderdate, int uid, int gid, int quantity, double allcount, String receive) {
		super();
		this.oid = oid;
		this.orderdate = orderdate;
		this.uid = uid;
		this.gid = gid;
		this.quantity = quantity;
		this.allcount = allcount;
		this.receive = receive;
	}

	public Order(String orderdate, int uid, int gid, int quantity, double allcount, String receive) {
		super();
		this.orderdate = orderdate;
		this.uid = uid;
		this.gid = gid;
		this.quantity = quantity;
		this.allcount = allcount;
		this.receive = receive;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAllcount() {
		return allcount;
	}

	public void setAllcount(double allcount) {
		this.allcount = allcount;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderdate=" + orderdate + ", uid=" + uid + ", gid=" + gid + ", quantity="
				+ quantity + ", allcount=" + allcount + ", receive=" + receive + "]";
	}

	
}

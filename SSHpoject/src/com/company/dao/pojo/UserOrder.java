package com.company.dao.pojo;

public class UserOrder {
	private int uoid;
	private int uid;
	private String orderdate;
	private String receive;
	public UserOrder() {
		// TODO Auto-generated constructor stub
	}
	public UserOrder(int uoid, int uid, String orderdate, String receive) {
		super();
		this.uoid = uoid;
		this.uid = uid;
		this.orderdate = orderdate;
		this.receive = receive;
	}
	public UserOrder(int uid, String orderdate, String receive) {
		super();
		this.uid = uid;
		this.orderdate = orderdate;
		this.receive = receive;
	}
	public int getUoid() {
		return uoid;
	}
	public void setUoid(int uoid) {
		this.uoid = uoid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	@Override
	public String toString() {
		return "UserOrder [uoid=" + uoid + ", uid=" + uid + ", orderdate=" + orderdate + ", receive=" + receive + "]";
	}
	
}

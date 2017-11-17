package com.company.dao.pojo;

import java.math.BigInteger;

public class Money {
	private int uid;
	private BigInteger bankcard;
	private double balance;
	private String receive1;
	private String receive2;
	private String receive3;
	public Money() {
		// TODO Auto-generated constructor stub
	}
	public Money(int uid, BigInteger bankcard, double balance, String receive1, String receive2, String receive3) {
		super();
		this.uid = uid;
		this.bankcard = bankcard;
		this.balance = balance;
		this.receive1 = receive1;
		this.receive2 = receive2;
		this.receive3 = receive3;
	}
	public Money(String receive1, String receive2, String receive3) {
		super();
		this.receive1 = receive1;
		this.receive2 = receive2;
		this.receive3 = receive3;
	}
	public Money(BigInteger bankcard) {
		super();
		this.bankcard = bankcard;
	}
	public Money(double balance) {
		super();
		this.balance = balance;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public BigInteger getBankcard() {
		return bankcard;
	}
	public void setBankcard(BigInteger bankcard) {
		this.bankcard = bankcard;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getReceive1() {
		return receive1;
	}
	public void setReceive1(String receive1) {
		this.receive1 = receive1;
	}
	public String getReceive2() {
		return receive2;
	}
	public void setReceive2(String receive2) {
		this.receive2 = receive2;
	}
	public String getReceive3() {
		return receive3;
	}
	public void setReceive3(String receive3) {
		this.receive3 = receive3;
	}
	@Override
	public String toString() {
		return "Money [uid=" + uid + ", bankcard=" + bankcard + ", balance=" + balance + ", receive1=" + receive1
				+ ", receive2=" + receive2 + ", receive3=" + receive3 + "]";
	}
	
}

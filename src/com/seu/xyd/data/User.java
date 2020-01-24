package com.seu.xyd.data;

import java.util.Calendar;

public class User {
    long id = 0;
    String account = "";
    String pw = "";
    String email = "";
    String phoneNum = "";
    double balance = 0.0;
    boolean bunusFlag = false;
    int state = 0;
    int defReceiverInfoId = 0;
	public int getDefReceiverInfoId() {
		return defReceiverInfoId;
	}
	public void setDefReceiverInfoId(int defReceiverInfoId) {
		this.defReceiverInfoId = defReceiverInfoId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isBunusFlag() {
		return bunusFlag;
	}
	public void setBunusFlag(boolean bunusFlag) {
		this.bunusFlag = bunusFlag;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
    
	@Override
	public String toString() {
		String rlt = "User:\n"+
				account+"\n"+
				pw+"\n"+
				email+"\n"+
				phoneNum+"\n"+
				balance+"\n"+
				bunusFlag+"\n"+
				state+"\n";
		return rlt;
	}
	

}

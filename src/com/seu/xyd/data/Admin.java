package com.seu.xyd.data;

public class Admin {
    long id = 0;
    String name = "";
    String account = "";
    String pw = "";
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		String rlt = "Admin:\n"+
				id+"\n"+
				name+"\n"+
				account+"\n"+
				pw+"\n";
		return rlt;
	}

	

}

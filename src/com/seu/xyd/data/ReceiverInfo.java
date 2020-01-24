package com.seu.xyd.data;

public class ReceiverInfo {
    long id = 0;
    long userId = 0;
    String recName = "";
    String recProv = "";
    String recCity = "";
    String recArea = "";
    String recAddrDetail = "";
    String recPhonenum = "";
    int state = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getRecProv() {
		return recProv;
	}

	public void setRecProv(String recProv) {
		this.recProv = recProv;
	}

	public String getRecCity() {
		return recCity;
	}

	public void setRecCity(String recCity) {
		this.recCity = recCity;
	}

	public String getRecArea() {
		return recArea;
	}

	public void setRecArea(String recArea) {
		this.recArea = recArea;
	}

	public String getRecAddrDetail() {
		return recAddrDetail;
	}

	public void setRecAddrDetail(String recAddrDetail) {
		this.recAddrDetail = recAddrDetail;
	}

	public String getRecPhonenum() {
		return recPhonenum;
	}

	public void setRecPhonenum(String recPhonenum) {
		this.recPhonenum = recPhonenum;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		String rlt = "ReceiverInfo:\n"+
				id+"\n"+
				userId+"\n"+
				recName+"\n"+
				recProv+"\n"+
				recCity+"\n"+
				recArea+"\n"+
				recAddrDetail+"\n"+
				recPhonenum+"\n"+
				state+"\n";
		return rlt;
	}


	

}

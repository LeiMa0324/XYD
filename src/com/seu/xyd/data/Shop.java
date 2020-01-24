package com.seu.xyd.data;

import java.util.Calendar;

public class Shop {
    long id = 0;
    String name = "";
    String account = "";
    String pw = "";
    String desc = "";
    String img = "";
    String addrProvince = "";
    String addrCity = "";
    String addrArea = "";
    String addrDesc = "";
    double coordinateX = 0.0; //经纬度
    double coordinateY = 0.0;
    String phoneNum = "";
    int state = 0;
    
    //not in DB
    double length = 0.0;
    int sellNum = 0;
    
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAddrProvince() {
		return addrProvince;
	}
	public void setAddrProvince(String addrProvince) {
		this.addrProvince = addrProvince;
	}
	public String getAddrCity() {
		return addrCity;
	}
	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}
	public String getAddrArea() {
		return addrArea;
	}
	public void setAddrArea(String addrArea) {
		this.addrArea = addrArea;
	}
	public String getAddrDesc() {
		return addrDesc;
	}
	public void setAddrDesc(String addrDesc) {
		this.addrDesc = addrDesc;
	}
	public double getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}
	public double getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getSellNum() {
		return sellNum;
	}
	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}
	@Override
	public String toString() {
		String rlt = "Shop:\n"+
				id+"\n"+
				name+"\n"+
				account+"\n"+
				pw+"\n"+
				desc+"\n"+
				img+"\n"+
				addrProvince+"\n"+
				addrCity+"\n"+
				addrArea+"\n"+
				addrDesc+"\n"+
				coordinateX+"\n"+
				coordinateY+"\n"+
				phoneNum+"\n"+
				state+"\n";
		return rlt;
	}
	

}

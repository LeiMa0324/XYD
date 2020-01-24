package com.seu.xyd.data;

import java.util.Calendar;

import com.tn17.util.TimeUtil;

public class Order {
    long id = 0;
    String num = "";
    String address = "";
    double priceSum = 0.0;
    Calendar createtime = Calendar.getInstance();
    long userId = 0;
    long shopId = 0;
    boolean reviewFlag = false;
    String reviewdetail = "";
    int reviewLevel = 0;
    int state = 0;
    
    //not in DB
    User user = null;
    Shop shop = null;
    Goods goods[] = null;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(double priceSum) {
		this.priceSum = priceSum;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public boolean isReviewFlag() {
		return reviewFlag;
	}
	public void setReviewFlag(boolean reviewFlag) {
		this.reviewFlag = reviewFlag;
	}
	public String getReviewdetail() {
		return reviewdetail;
	}
	public void setReviewdetail(String reviewdetail) {
		this.reviewdetail = reviewdetail;
	}
	public int getReviewLevel() {
		return reviewLevel;
	}
	public void setReviewLevel(int reviewLevel) {
		this.reviewLevel = reviewLevel;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Goods[] getGoods() {
		return goods;
	}
	public void setGoods(Goods[] goods) {
		this.goods = goods;
	}
	
	public Calendar getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Calendar createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		String rlt = "Order:\n"+
				num+"\n"+
				address+"\n"+
				priceSum+"\n"+
				TimeUtil.parseTime(createtime)+"\n"+
				userId+"\n"+
				shopId+"\n"+
				reviewFlag+"\n"+
				reviewdetail+"\n"+
				reviewLevel+"\n"+
				state+"\n";
		return rlt;
	}
}

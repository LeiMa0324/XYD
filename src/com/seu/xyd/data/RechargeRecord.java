package com.seu.xyd.data;

import java.util.Calendar;

import com.tn17.util.TimeUtil;

public class RechargeRecord {
    long id = 0;
    long userId = 0;
    double amount = 0.0;
    Calendar createtime = Calendar.getInstance();
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Calendar getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Calendar createtime) {
		this.createtime = createtime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
    
	@Override
	public String toString() {
		String rlt = "RechargeRecord:\n"+
				id+"\n"+
				userId+"\n"+
				amount+"\n"+
				TimeUtil.parseTime(createtime)+"\n"+
				state+"\n";
		return rlt;
	}
	

}

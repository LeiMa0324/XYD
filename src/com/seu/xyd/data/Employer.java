package com.seu.xyd.data;

import java.util.Calendar;

import com.tn17.util.TimeUtil;

public class Employer {
    long id = 0;
    long shopId = 0;
    String name = "";
    String sex = "";
    Calendar birthday = Calendar.getInstance();
    String desc = "";
    int state = 0;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		String rlt = "Employer:\n"+
				shopId+"\n"+
				name+"\n"+
				sex+"\n"+
				TimeUtil.parseTime(birthday)+"\n"+
				desc+"\n"+
				state+"\n";
		return rlt;
	}


}

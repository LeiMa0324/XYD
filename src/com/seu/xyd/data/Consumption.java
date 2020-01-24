package com.seu.xyd.data;


public class Consumption {
    long id = 0;
    long shopId = 0;
    String name = "";
    int amount = 0;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		String rlt = "Consumption:\n"+
				shopId+"\n"+
				name+"\n"+
				amount+"\n"+
				state+"\n";
		return rlt;
	}

}

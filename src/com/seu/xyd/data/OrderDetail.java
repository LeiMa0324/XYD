package com.seu.xyd.data;

public class OrderDetail {
    long id = 0;
    long goodsId = 0; 
    long orderId = 0;
    int amount = 0;
    int state =0;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
		String rlt = "OrderDetail:\n"+
				id+"\n"+
				goodsId+"\n"+
				orderId+"\n"+
				amount+"\n"+
				state+"\n";
		return rlt;
	}
 
}

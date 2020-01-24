package com.seu.xyd.data;

public class Goods {
    long id = 0;
    String name = "";
    long shopId = 0;
    double price = 0.0;
    String logo = "";
    int state = 0;
    
    GoodsImg[] goodsImgs = new GoodsImg[0];

    
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


	public long getShopId() {
		return shopId;
	}


	public void setShopId(long shopId) {
		this.shopId = shopId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public GoodsImg[] getGoodsImgs() {
		return goodsImgs;
	}


	public void setGoodImgs(GoodsImg[] goodsImgs) {
		this.goodsImgs = goodsImgs;
	}


	@Override
	public String toString() {
		String rlt = "Goods:\n"+
				id+"\n"+
				name+"\n"+
				shopId+"\n"+
				price+"\n"+
				logo+"\n"+
				state+"\n";
		return rlt;
	}
	

}

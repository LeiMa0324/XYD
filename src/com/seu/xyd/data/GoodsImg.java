package com.seu.xyd.data;

public class GoodsImg {
    long id = 0;
    long goodsId = 0;
    String imgUrl = "";
    String imgDesc = "";
    int state = 0;



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



	public String getImgUrl() {
		return imgUrl;
	}



	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public String getImgDesc() {
		return imgDesc;
	}



	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	@Override
	public String toString() {
		String rlt = "GoodsImg:\n"+
				id+"\n"+
				goodsId+"\n"+
				imgUrl+"\n"+
				imgDesc+"\n"+
				state+"\n";
		return rlt;
	}
	

}

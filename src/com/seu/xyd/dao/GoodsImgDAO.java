package com.seu.xyd.dao;


import com.seu.xyd.data.GoodsImg;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface GoodsImgDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for Goods
    long insertGoodsImg(GoodsImg goodsImg) throws DBProcessException;
    GoodsImg selectGoodsImg(long id) throws DBProcessException, NoSuchCase;
    void deleteGoodsImg(long id) throws DBProcessException, NoSuchCase;
    void updateGoodsImg(GoodsImg goodsImg) throws DBProcessException, NoSuchCase;
    GoodsImg[] selectGoodsImgs() throws DBProcessException;
	GoodsImg[] selectGoodsImgsByGoodsId(long goodsId) throws DBProcessException;

	



}

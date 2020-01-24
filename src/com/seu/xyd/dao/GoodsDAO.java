package com.seu.xyd.dao;


import com.seu.xyd.data.Goods;
import com.seu.xyd.data.Shop;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface GoodsDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for Goods
    long insertGoods(Goods Goods) throws DBProcessException;
    Goods selectGoods(long id) throws DBProcessException, NoSuchCase;
    void deleteGoods(long id) throws DBProcessException, NoSuchCase;
    void updateGoods(Goods goods) throws DBProcessException, NoSuchCase;
	Goods[] selectGoodss() throws DBProcessException;
	Goods[] selectGoodssByShopId(long shopId) throws DBProcessException;

	int getGoodsCountByShopId(long id) throws DBProcessException;

	Goods[] getGoodsListByShopIdWithPage(long id, int page) throws DBProcessException;

	Goods[] getGoodsByGoodsIdArrStr(String goodsIdArrStr) throws DBProcessException;

	



}

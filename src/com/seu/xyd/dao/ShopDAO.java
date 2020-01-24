package com.seu.xyd.dao;


import com.seu.xyd.data.Employer;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface ShopDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for Shop
    long insertShop(Shop shop) throws DBProcessException;
    Shop selectShop(long id) throws DBProcessException, NoSuchCase;
    Shop selectShopByAccount(String account) throws DBProcessException, NoSuchCase;
    void deleteShop(long id) throws DBProcessException, NoSuchCase;
    void updateShop(Shop shop) throws DBProcessException, NoSuchCase;
    void DeleteGoodByid(int id) throws DBProcessException, NoSuchCase;
    long insertGoods(Goods goods) throws DBProcessException;
	Shop[] selectShops() throws DBProcessException;

	Shop[] getShopListByLngAndLat(float lng, float lat) throws DBProcessException;
	Shop[] getShopListByShopIdWithPage(String keyWord, int page) throws DBProcessException;

	int getEmployerCountByShopId(int shopId);

	Employer[] getEmployerListByShopIdAndKeyword(int shopId, String empname_keyword, int page);

}

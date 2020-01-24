package com.seu.xyd.dao;


import com.seu.xyd.data.Order;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface OrderDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for Order
    long insertOrder(Order order) throws DBProcessException;
    Order selectOrder(long id) throws DBProcessException, NoSuchCase;
    void deleteOrder(long id) throws DBProcessException, NoSuchCase;
    void updateOrder(Order order) throws DBProcessException, NoSuchCase;

	Order[] selectOrders() throws DBProcessException;
	Order[] selectOrdersByShopId(long shopId) throws DBProcessException;
	Order[] selectOrdersByUserId(long userId) throws DBProcessException;
	
	//马蕾的代码
	Order[] selectOrdersByShopIdAndKeyword(long shopId,String keyword, int page) throws DBProcessException;
	Order[] selectOrdersByShopIdAndOrderState(long shopId,int orderstate, int page) throws DBProcessException;

	int getOrderNeedProcessCount(int shopId, int orderState) throws DBProcessException;

	int getOrderCountByShopIdAndState(int shopId, int orderState) throws DBProcessException;





}

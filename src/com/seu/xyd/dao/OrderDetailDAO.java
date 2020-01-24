package com.seu.xyd.dao;


import com.seu.xyd.data.OrderDetail;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;

public interface OrderDetailDAO {
    void deleteAllDataONLYFORTEST() throws DBProcessException;
    
    //for orderDetail
    long insertOrderDetail(OrderDetail orderDetail) throws DBProcessException;
    OrderDetail selectOrderDetail(long id) throws DBProcessException, NoSuchCase;
    void deleteOrderDetail(long id) throws DBProcessException, NoSuchCase;
    void updateOrderDetail(OrderDetail orderDetail) throws DBProcessException, NoSuchCase;


	OrderDetail getOrderDetail(int id) throws DBProcessException, NoSuchCase;


	OrderDetail[] selectOrderDetailsByOrderId(long orderId)
			throws DBProcessException;

    


}

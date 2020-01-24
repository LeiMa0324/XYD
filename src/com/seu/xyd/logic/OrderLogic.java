package com.seu.xyd.logic;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.sql.rowset.serial.SerialException;

import org.jfree.data.general.SeriesException;

import com.seu.xyd.dao.DAOFactory;
import com.seu.xyd.dao.OrderDAO;
import com.seu.xyd.dao.OrderDetailDAO;
import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.OrderDetail;
import com.seu.xyd.data.User;
import com.seu.xyd.data.XYDErrors;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;
public class OrderLogic {
    private static OrderLogic instance = null;
    private final OrderDAO oDao = DAOFactory.getOrderDAO();
    private final OrderDetailDAO odDao = DAOFactory.getOrderDetailDAO();
    private OrderLogic() {
        // lock it
    }

    public synchronized static OrderLogic getInstance() {
        if (instance == null) {
            instance = new OrderLogic();
        }
        return instance;
    }

	public Order[] getOrderListByShopId(int id) throws DBProcessException {
		return oDao.selectOrdersByShopId(id);
	}
    //马蕾的代码
	public Order[] getOrderListByShopIdAndKeyword(long id,String keyword, int page) throws DBProcessException {
		return oDao.selectOrdersByShopIdAndKeyword(id,keyword,page);
	}
	public Order[] getOrderListByShopIdAndOrderState(long id,int orderstate, int page) throws DBProcessException {
		return oDao.selectOrdersByShopIdAndOrderState(id,orderstate,page);
	}

	public int getOrderNeedProcessCount(int shopId, int orderState) throws DBProcessException {
		return  oDao.getOrderNeedProcessCount(shopId,orderState);
	}

	public int getOrderCountByShopIdAndState(int shopId, int orderState) throws DBProcessException {
		return  oDao.getOrderCountByShopIdAndState(shopId,orderState);
	}

	public Order getOrderById(int id) throws DBProcessException, ServletException {
		try {
			return oDao.selectOrder(id);
		} catch (NoSuchCase e) {
			throw new ServletException("找不到数据");
		}
	}

	public OrderDetail[] getOrderDetailByOrderId(long id) throws DBProcessException {
		return odDao.selectOrderDetailsByOrderId(id);
	}

	public void updateOrder(Order order) throws DBProcessException, ServletException {
		try {
			oDao.updateOrder(order);
		} catch (NoSuchCase e) {
			throw new ServletException("数据异常");
		}
	}

	public long insertOrder(Order order) throws DBProcessException {
		return oDao.insertOrder(order);
	}

	public long insertOrderDetail(OrderDetail orderDetail) throws DBProcessException {
		return odDao.insertOrderDetail(orderDetail);
		
	}
}

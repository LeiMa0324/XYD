package com.seu.xyd.logic;

import javax.servlet.ServletException;

import org.junit.Test;

import com.seu.xyd.dao.DAOFactory;
import com.seu.xyd.dao.OrderDAO;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;

public class OrderLogicTest {
	@Test
	public void initOrderData() throws DBProcessException, ServletException{
final OrderDAO oDao = DAOFactory.getOrderDAO();
		
		Order order = new Order();
		order.setNum("DS156467458754686547");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(0);
		
		oDao.insertOrder(order);
		
		order.setNum("DS165475686786");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(0);
		
		oDao.insertOrder(order);
		
		order.setNum("DS21654567547");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(0);
		
		oDao.insertOrder(order);
		
		order.setNum("DS0896785363");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(1);
		
		oDao.insertOrder(order);
		
		order.setNum("DS2645756867867");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(2);
		
		oDao.insertOrder(order);
		
		order.setNum("DS8809807676");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(3);
		
		oDao.insertOrder(order);
		
		order.setNum("DS7452724587");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(4);
		
		oDao.insertOrder(order);
		
		order.setNum("DS246425745764");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(5);
		
		oDao.insertOrder(order);
		
		order.setNum("DS247245245645");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(0);
		
		oDao.insertOrder(order);
		
		order.setNum("DS67867845673");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(1);
		
		oDao.insertOrder(order);
		
		order.setNum("DS67867856");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(2);
		
		oDao.insertOrder(order);
		
		order.setNum("DS5645645634");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(3);
		
		oDao.insertOrder(order);
		
		order.setNum("DS634563453");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(4);
		
		oDao.insertOrder(order);
		
		order.setNum("DS534535423");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(5);
		
		oDao.insertOrder(order);
		
		order.setNum("D2342354353");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(1);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(2);
		
		oDao.insertOrder(order);
	}
	
}

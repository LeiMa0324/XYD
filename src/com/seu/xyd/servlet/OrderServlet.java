package com.seu.xyd.servlet;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.seu.xyd.dao.mysql.UserDAOUtil;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.OrderDetail;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.seu.xyd.data.XYDErrors;
import com.seu.xyd.logic.LogicUtil;
import com.seu.xyd.logic.OrderLogic;
import com.seu.xyd.logic.ShopLogic;
import com.seu.xyd.logic.UserLogic;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;
import com.tn17.util.ArrayUtil;
import com.tn17.util.TimeUtil;

/**
 * Servlet implementation class userServlet
 */
public class OrderServlet extends XYDServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418032213105965975L;
    final OrderLogic oL = OrderLogic.getInstance();
    final ShopLogic sL = ShopLogic.getInstance();

	@Override
	String process(HttpServletRequest request) throws LogicException,
			DBProcessException, ServletException {
		Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element result = root.addElement("result");
        
        XYDWebOP op = XYDWebOP.valueOfName(UIUtil.getParam(request, XYDWebParam.OP));
        switch (op) {
        case GET_ORDER_LIST_BY_SHOP_ID: {
            getOrderListByShopId(request, result);
            break;
        }
        case GET_ORDER_LIST_BY_SHOP_ID_AND_KEYWORD: {
            getOrderListByShopIdAndKeyword(request, result);
            break;
        }
        
        case GET_ORDER_LIST_BY_SHOP_ID_AND_ORDER_STATE:{
            getOrderListByShopIdAndOrderState(request, result);
            break;
        }
        case GET_ORDER_BY_ID:{
        	getOrderById(request,result);
        	break;
        }
        case UPDAYE_ORDER_STATE_BY_ORDER_ID_AND_TARGET_STATE:{
        	updateOrderStateByOrderIdAndTargetState(request, result);
        	break;
        }
        case ADD_NEW_ORDER:{
        	addNewOrder(request,result);
        	break;
        }
        default:
            assert false:"no such op"+op.getName();
            break;
        }
        
        return result.asXML();
	}


	private synchronized void addNewOrder(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int shopId = UIUtil.getParamInInt(request, XYDWebParam.SHOP_ID);
		String idAndAmountStr = UIUtil.getParam(request, XYDWebParam.ARRAY_STRING);
		String [] idAndAmountArr = idAndAmountStr.split(",");
		
		String orderCode = "DS"+Calendar.getInstance().getTimeInMillis();
		User user = UIUtil.getLogonUser(request.getSession());
		Order order = new Order();
		order.setNum(orderCode);
		order.setShopId(shopId);
		order.setUserId(user.getId());
		long orderId = oL.insertOrder(order);
		
		List<OrderDetail> rlt = new ArrayList<OrderDetail>();
		for(String idAndAmount : idAndAmountArr){
			int []data = ArrayUtil.parseIntArray(idAndAmount, "_");
			if(data.length==2){
				OrderDetail one = new OrderDetail();
				one.setGoodsId(data[0]);
				one.setAmount(data[1]);
				one.setOrderId(orderId);
                rlt.add(one);
			}
		}
		double sumMoneyOfOrder = 0.0;
		OrderDetail[] orderDetails = rlt.toArray(new OrderDetail[0]);
		List<Goods> rltOfGoodsList = new ArrayList<Goods>();
		//System.out.println(orderDetails.length);
		for(OrderDetail orderDetail: orderDetails){
			Goods goods = sL.getGoodsByGoodsId(orderDetail.getGoodsId());
			sumMoneyOfOrder = sumMoneyOfOrder+goods.getPrice()*orderDetail.getAmount();
			oL.insertOrderDetail(orderDetail);
			rltOfGoodsList.add(goods);
		}
		//更新订单金额
		order.setId(orderId);
		order.setPriceSum(sumMoneyOfOrder);
		oL.updateOrder(order);
		
		
	}


	private void getOrderById(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int id = UIUtil.getParamInInt(request, XYDWebParam.ID);
		Order order = oL.getOrderById(id);
		OrderDetail[] orderDetails = oL.getOrderDetailByOrderId(order.getId());
		UIUtil.appendOrderToXML(order, result);
		for(OrderDetail orderDetail : orderDetails){
			UIUtil.appendOrderDetailToXML(orderDetail, result);
		}
	}



	private void getOrderListByShopId(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		int id = UIUtil.getParamInInt(request, XYDWebParam.ID);
		//int id=1;
		Order[] orders = oL.getOrderListByShopId(id);
		for(Order order : orders){
			UIUtil.appendOrderToXML(order, result);
		}
		
	}
	
	private void getOrderListByShopIdAndKeyword(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		//Shop shop = UIUtil.getLogonShop(request.getSession());
		String keyword=UIUtil.getParam(request, XYDWebParam.KEYWORD);
		int page=UIUtil.getParamInInt(request, XYDWebParam.PAGE);
		System.out.println(keyword);
		int shopId = 2;
		Order[] orders = oL.getOrderListByShopIdAndKeyword(shopId,keyword,page);
		int badge = oL.getOrderNeedProcessCount(shopId,-1);
		int total = oL.getOrderCountByShopIdAndState(shopId,-1);
		result.addAttribute("badge", badge+"");
		result.addAttribute("total", total+"");
		for(Order order : orders){
			UIUtil.appendOrderToXML(order, result);
		}
		//
	}
	
	private void getOrderListByShopIdAndOrderState(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		//Shop shop = UIUtil.getLogonShop(request.getSession());
		int orderState=UIUtil.getParamInInt(request, XYDWebParam.ORDER_STATE);
		int page=UIUtil.getParamInInt(request, XYDWebParam.PAGE);
		int shopId = 2;
		//System.out.println(orderState);
		Order[] orders = oL.getOrderListByShopIdAndOrderState(shopId,orderState,page);
		int badge = oL.getOrderNeedProcessCount(shopId,orderState);
		int total = oL.getOrderCountByShopIdAndState(shopId,orderState);
		result.addAttribute("badge", badge+"");
		result.addAttribute("total", total+"");
		for(Order order : orders){
			UIUtil.appendOrderToXML(order, result);
		}
		//
	}

	
	private void updateOrderStateByOrderIdAndTargetState(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		// TODO Auto-generated method stub
		int orderId=UIUtil.getParamInInt(request, XYDWebParam.ID);
		int targetState=UIUtil.getParamInInt(request, XYDWebParam.ORDER_STATE);
		//返回一个order对象
		
		Order order=oL.getOrderById(orderId);
		order.setState(targetState);
		oL.updateOrder(order);
		//UIUtil.appendOrderToXML(order, result);
	}


}

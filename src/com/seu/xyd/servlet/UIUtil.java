package com.seu.xyd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Element;

import com.seu.xyd.data.Admin;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.OrderDetail;
import com.seu.xyd.data.ReceiverInfo;
import com.seu.xyd.data.RechargeRecord;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.seu.xyd.data.Employer;
import com.tn17.util.ArrayUtil;
import com.tn17.util.CommonUtil;
import com.tn17.util.TimeUtil;

public class UIUtil {
    final public static String SESSION_ATTRIBUTE_KEY_FOR_USER = "user";
    final public static String SESSION_ATTRIBUTE_KEY_FOR_SHOP = "shop";
    final public static String SESSION_ATTRIBUTE_KEY_FOR_ADMIN = "admin";
    final public static String SESSION_ATTRIBUTE_KEY_FOR_ROLE = "role";
    final public static String SESSION_ATTRIBUTE_KEY_FOR_MSG = "msg";
    public static final String CONFIG = "com.seu.xyd.config.config";
    
    
    public static String getParam(HttpServletRequest request, XYDWebParam op) throws ServletException {
        return getParam(request, op, true);
    }
    
    public static String getParam(HttpServletRequest request, XYDWebParam op, boolean isThrowingNonExistException)
            throws ServletException {
        String value = request.getParameter(op.getName());
        if (value == null) {
            if (isThrowingNonExistException)
                throw new ServletException("Non-Exist Param! name=" + op.getName());
            return "";
        }
        return value.trim();
    }
    
    public static int[] getParamsInInt(HttpServletRequest request, XYDWebParam op) throws ServletException {
        return ArrayUtil.parseIntArray(getParams(request, op, true));
    }
    
    public static String[] getParams(HttpServletRequest request, XYDWebParam op) throws ServletException {
        return getParams(request, op, true);
    }
    
    public static String[] getParams(HttpServletRequest request, XYDWebParam op, boolean isThrowingNonExistException) throws ServletException {
        String[] values = request.getParameterValues(op.getName());
        if(values.length == 0) {
            if(isThrowingNonExistException)
                throw new ServletException("Non-Exist Param! name=" + op.getName());
        }
        return values;
    }
    
    public static long[] getParamsInLong(HttpServletRequest request, XYDWebParam op) throws ServletException {
        return ArrayUtil.parseLongArray(getParams(request, op));
    } 
    public static int[] getMultipleIntParams(HttpServletRequest request,
    		XYDWebParam key) {
    	String[] vs = getMultipleParams(request, key);
    	int[] rlt = new int[vs.length];
    	for (int i = 0; i < rlt.length; i++) {
    	    assert vs[i] != null && vs[i].length() > 0 : "illegal int param! it's null! for "
    		    + key.getName();
    	    try {
    		rlt[i] = Integer.parseInt(vs[i]);
    	    } catch (NumberFormatException e) {
    		assert vs[i] != null && vs[i].length() > 0 : "illegal int param for "
    		        + key.getName() + ", value=" + vs[i];
    	    }
    	}

    	return rlt;
        }

        public static String[] getMultipleParams(HttpServletRequest request,
        		XYDWebParam key) {
    	String[] vs = request.getParameterValues(key.getName());
    	if (vs == null)
    	    vs = request.getParameterValues(key.getName() + "[]"); // TODO
    								   // 迁就jQuery!

    	assert vs != null : "null for param:" + key.getName();
    	return vs;
        }
    
    static void sendResponse(HttpServletResponse response, String str) throws IOException {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(str);
            out.flush();
        } finally {
            CommonUtil.closeSafely(out);
        }
    }

    public static boolean isLogon(final HttpSession session)
            throws ServletException {
    	String  role = (String) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ROLE);
        if (role == null)
            return false;
        if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_USER)){
        	if (session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_USER) == null)
                return false;
        }else if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_SHOP)){
        	if (session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_SHOP) == null)
                return false;
        }else if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_SHOP)){
        	if (session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ADMIN) == null)
                return false;
        }else{
        	return false;
        }
        return true;
    }
    public static boolean isUserLogon(final HttpSession session)
            throws ServletException {
    	if (session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_USER) == null)
            return false;
        return true;
    }
    public static boolean isShopLogon(final HttpSession session)
            throws ServletException {
    	if (session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_SHOP) == null)
            return false;
        return true;
    }
    public static boolean isAdminLogon(final HttpSession session)
            throws ServletException {
    	if (session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ADMIN) == null)
            return false;
        return true;
    }
    
    //TODO 对不对啊！要测试
    public static boolean getParamInBoolean(HttpServletRequest request, XYDWebParam key) throws ServletException {
        String value = getParam(request, key);
        try {
            if(value.equals("true"))
                return true;
            return false;
        } catch (NumberFormatException e) {
            throw new ServletException("Illegal Bool Param! value=" + value);
        }
    }
    
    public static int getParamInInt(HttpServletRequest request, XYDWebParam key) throws ServletException {
        String value = getParam(request, key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ServletException("Illegal Int Param! value=" + value);
        }
    }
    
    public static long getParamInLong(HttpServletRequest request, XYDWebParam key) throws ServletException {
        String value = getParam(request, key);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new ServletException("Illegal Long Param! value=" + value);
        }
    }
    
    public static float getParamInFloat(HttpServletRequest request, XYDWebParam key) throws ServletException {
        String value = getParam(request, key);
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            throw new ServletException("Illegal Float Param! value=" + value);
        }
    }
    
    public static Calendar getParamInDate(HttpServletRequest request, XYDWebParam key) throws ServletException {
        String value = getParam(request, key);
        return TimeUtil.parseDateString(value);
    }

	public static void logoutSafely(HttpSession session) {
		try {
            session.invalidate();
        } catch (IllegalStateException e) {
            //logger.errorLog("Error occurs when invalidate a session:" + e.getMessage());
        }
		
	}
	
	public static User getLogonUser(final HttpSession session) throws ServletException {
        if (!isUserLogon(session))
            throw new XYDSessionTimeout();
        try {
            User rlt = (User) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_USER);
            assert rlt != null;
            return rlt;
        } catch (ClassCastException e) {
            assert false : "Shouldn't occurs CastError! ";
            return null;
        }
    }
	public static Shop getLogonShop(final HttpSession session) throws ServletException {
        if (!isShopLogon(session))
            throw new XYDSessionTimeout();
        try {
        	Shop rlt = (Shop) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_SHOP);
            assert rlt != null;
            return rlt;
        } catch (ClassCastException e) {
            assert false : "Shouldn't occurs CastError! ";
            return null;
        }
    }
	public static Admin getLogonAdmin(final HttpSession session) throws ServletException {
        if (!isAdminLogon(session))
            throw new XYDSessionTimeout();
        try {
        	Admin rlt = (Admin) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ADMIN);
            assert rlt != null;
            return rlt;
        } catch (ClassCastException e) {
            assert false : "Shouldn't occurs CastError! ";
            return null;
        }
    }
	public static String getLogonRoleName(final HttpSession session) throws ServletException {
        if (!isLogon(session))
            throw new XYDSessionTimeout();
        try {
        	String  role = (String) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ROLE);
            assert role != null;
            if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_USER)){
            	User rlt = (User) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_USER);
            	return rlt.getAccount();
            }else if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_SHOP)){
            	Shop rlt = (Shop) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_SHOP);
            	return rlt.getName();
            }else if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_ADMIN)){
            	Admin rlt = (Admin) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ADMIN);
            	return rlt.getName();
            }else{
            	return "";
            }
        } catch (ClassCastException e) {
            assert false : "Shouldn't occurs CastError! ";
            return null;
        }
    }
	public static String getLogonRole(final HttpSession session) throws ServletException {
        if (!isLogon(session))
            throw new XYDSessionTimeout();
        try {
        	String  role = (String) session.getAttribute(SESSION_ATTRIBUTE_KEY_FOR_ROLE);
            assert role != null;
            if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_USER)){
            	return SESSION_ATTRIBUTE_KEY_FOR_USER;
            }else if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_SHOP)){
            	return SESSION_ATTRIBUTE_KEY_FOR_SHOP;
            }else if(role.equals(SESSION_ATTRIBUTE_KEY_FOR_ADMIN)){
            	return SESSION_ATTRIBUTE_KEY_FOR_ADMIN;
            }else{
            	return "";
            }
        } catch (ClassCastException e) {
            assert false : "Shouldn't occurs CastError! ";
            return null;
        }
    }
	
	
	public static String getRandomMsg() {
		Random random = new Random();
		int x = random.nextInt(899999);
		x = x+100000;
		return ""+x;
	}
	
	public static void appendUserToXML(User user, Element result) {
		Element e = result.addElement("user");
		e.addAttribute("id", user.getId()+"");
		e.addAttribute("account", user.getAccount());
		e.addAttribute("email", user.getEmail());
		e.addAttribute("phone", user.getPhoneNum());
		e.addAttribute("balance", user.getBalance()+"");
		e.addAttribute("def_rec_info_id", user.getDefReceiverInfoId()+"");

	}
	//张海越充值记录写入xml
	public static void appendChargeRecordToXML(RechargeRecord record, Element result) {
		Element e = result.addElement("chargerecord");
		e.addAttribute("id", record.getId()+"");
		e.addAttribute("userId", record.getUserId()+"");
		e.addAttribute("createtime",TimeUtil.parseTime(record.getCreatetime()));
		e.addAttribute("account", record.getAmount()+"");
		e.addAttribute("state", record.getState()+"");
		
	}
	//张海越收货地址写入xml
	public static void appendReceiverInfoToXML(ReceiverInfo receiverinfo, Element result) {
		Element e = result.addElement("receiverinfo");
		e.addAttribute("id", receiverinfo.getId()+"");
		e.addAttribute("recName", receiverinfo.getRecName()+"");
		e.addAttribute("recPhonenum",receiverinfo.getRecPhonenum()+"");
		e.addAttribute("addressProv", receiverinfo.getRecProv()+"");
		e.addAttribute("addressCity", receiverinfo.getRecCity()+"");
		e.addAttribute("addressArea", receiverinfo.getRecArea()+"");
		e.addAttribute("addressDetail", receiverinfo.getRecAddrDetail()+"");
		
	}
	
	//xml中返回的order字段内容
	public static void appendOrderToXML(Order order, Element result) {
		Element e = result.addElement("order");
		e.addAttribute("id", order.getId()+"");
		e.addAttribute("num", order.getNum());
		e.addAttribute("address", order.getAddress());
		e.addAttribute("price_sum", order.getPriceSum()+"");
		e.addAttribute("user_id", order.getUserId()+"");
		e.addAttribute("shop_id", order.getShopId()+"");
		e.addAttribute("review_flag", (order.isReviewFlag()==true?1:0)+"");
		e.addAttribute("review_detail", order.getReviewdetail());
		e.addAttribute("review_level", order.getReviewdetail());
		e.addAttribute("createtime", TimeUtil.parseTime(order.getCreatetime()));
		e.addAttribute("state", order.getState()+"");
	}

	public static void appendGoodsToXML(Goods goods, Element result) {
		Element e = result.addElement("goods");
		e.addAttribute("id", goods.getId()+"");
		e.addAttribute("name", goods.getName());
		e.addAttribute("shop_id", goods.getShopId()+"");
		e.addAttribute("price", goods.getPrice()+"");
		e.addAttribute("img", goods.getLogo());
		e.addAttribute("state", goods.getState()+"");
	}
	public static void appendGoodsWithXML(Goods goods, Element e) {
		e.addAttribute("id", goods.getId()+"");
		e.addAttribute("name", goods.getName());
		e.addAttribute("shop_id", goods.getShopId()+"");
		e.addAttribute("price", goods.getPrice()+"");
		e.addAttribute("img", goods.getLogo());
		e.addAttribute("state", goods.getState()+"");
	}
	public static void appendShopToXML(Shop shop, Element result) {
		Element e = result.addElement("shop");
		e.addAttribute("id", shop.getId()+"");
		e.addAttribute("name", shop.getName());
		e.addAttribute("account", shop.getAccount());
		e.addAttribute("img", shop.getImg());
		e.addAttribute("phone", shop.getPhoneNum());
		e.addAttribute("desc", shop.getDesc());
		e.addAttribute("addr_prov", shop.getAddrProvince());
		e.addAttribute("addr_city", shop.getAddrCity());
		e.addAttribute("addr_area", shop.getAddrArea());
		e.addAttribute("addr_desc", shop.getAddrDesc());
		e.addAttribute("length", shop.getLength()+"");
	}

	
	public static void appendEmployersWithXML(Employer employer, Element result) {
		//将employer加入result中
		Element e = result.addElement("employer");
		e.addAttribute("id", employer.getId()+"");
		e.addAttribute("shop_id", employer.getShopId()+"");
		e.addAttribute("name", employer.getName());
		e.addAttribute("sex", employer.getSex());
		e.addAttribute("birthday", employer.getBirthday()+"");
		e.addAttribute("desc", employer.getDesc());
		e.addAttribute("state", employer.getState()+"");
	}


	public static void appendOrderDetailToXML(OrderDetail orderDetail,Element result) {
		Element e = result.addElement("order_detail");
		e.addAttribute("id", orderDetail.getId()+"");
		e.addAttribute("goods_id", orderDetail.getGoodsId()+"");
		e.addAttribute("order_id", orderDetail.getOrderId()+"");
		e.addAttribute("state", orderDetail.getState()+"");
	}

}

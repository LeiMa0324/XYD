package com.seu.xyd.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.seu.xyd.data.Admin;
import com.seu.xyd.data.Consumption;
import com.seu.xyd.data.Employer;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.GoodsImg;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.OrderDetail;
import com.seu.xyd.data.ReceiverInfo;
import com.seu.xyd.data.RechargeRecord;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBUtil;

public class UserDAOUtil {
    static final String SPLIT_OF_SV_TITLES = "_";
    
    static final String[] tables ={ Def.T_USER,Def.T_ADMIN,Def.T_CONSUMPTION,
    	Def.T_EMPLOYER,Def.T_GOODS,Def.T_ORDER,Def.T_ORDER_DETAIL,
    	Def.T_RECHARGE_RECORD,Def.T_SHOP};
    
    static void setFields(User target, PreparedStatement stmt) throws SQLException {
        assert Def.USER_FIELDS.length == 8;
        stmt.setString(1, target.getAccount());
        stmt.setString(2, target.getPw());
        stmt.setString(3, target.getEmail());
        stmt.setString(4, target.getPhoneNum());
        stmt.setDouble(5, target.getBalance());
        stmt.setBoolean(6, target.isBunusFlag());
        stmt.setInt(7, target.getState());
        stmt.setInt(8, target.getDefReceiverInfoId());
    }
    
    static User parseUser(ResultSet rs) throws SQLException {
        assert Def.USER_FIELDS.length == 8;
        String[] fields = Def.USER_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        String account = DBUtil.getString(rs, fields[0]);
        String pw = DBUtil.getString(rs, fields[1]);
        String email = DBUtil.getString(rs, fields[2]);
        String phoneNum = DBUtil.getString(rs, fields[3]);
        double balance = DBUtil.getFloat(rs, fields[4]);
        boolean bunusFlag = DBUtil.getBoolean(rs, fields[5]);
        int state = DBUtil.getInt(rs, fields[6]);
        int defReceiverInfoId = DBUtil.getInt(rs, fields[7]);
        
        User user = new User();
        user.setId(id);
        user.setAccount(account);
        user.setPw(pw);
        user.setEmail(email);
        user.setPhoneNum(phoneNum);
        user.setBalance(balance);
        user.setBunusFlag(bunusFlag);
        user.setState(state);
        user.setDefReceiverInfoId(defReceiverInfoId);
        return user;
    }

	public static void setFields(Shop target, PreparedStatement stmt) throws SQLException {
		assert Def.SHOP_FIELDS.length == 13;
        stmt.setString(1, target.getName());
        stmt.setString(2, target.getAccount());
        stmt.setString(3, target.getPw());
        stmt.setString(4, target.getDesc());
        stmt.setString(5, target.getImg());
        stmt.setString(6, target.getAddrProvince());
        stmt.setString(7, target.getAddrCity());
        stmt.setString(8, target.getAddrArea());
        stmt.setString(9, target.getAddrDesc());
        stmt.setDouble(10, target.getCoordinateX());
        stmt.setDouble(11, target.getCoordinateY());
        stmt.setString(12, target.getPhoneNum());
        stmt.setInt(13, target.getState());
		
	}
	static Shop parseShop(ResultSet rs) throws SQLException {
        assert Def.SHOP_FIELDS.length == 13;
        String[] fields = Def.SHOP_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        String name = DBUtil.getString(rs, fields[0]);
        String account = DBUtil.getString(rs, fields[1]);
        String pw = DBUtil.getString(rs, fields[2]);
        String desc = DBUtil.getString(rs, fields[3]);
        String img = DBUtil.getString(rs, fields[4]);
        String addrProvince = DBUtil.getString(rs, fields[5]);
        String addrCity = DBUtil.getString(rs, fields[6]);
        String addrArea = DBUtil.getString(rs, fields[7]);
        String addrDesc = DBUtil.getString(rs, fields[8]);
        double coordinateX = DBUtil.getFloat(rs, fields[9]);
        double coordinateY = DBUtil.getFloat(rs, fields[10]);
        String phoneNum = DBUtil.getString(rs, fields[11]);
        int state = DBUtil.getInt(rs, fields[12]);

        Shop shop = new Shop();
        shop.setId(id);
        shop.setName(name);
        shop.setAccount(account);
        shop.setPw(pw);
        shop.setDesc(desc);
        shop.setImg(img);
        shop.setAddrProvince(addrProvince);
        shop.setAddrCity(addrCity);
        shop.setAddrArea(addrArea);
        shop.setAddrDesc(addrDesc);
        shop.setCoordinateX(coordinateX);
        shop.setCoordinateY(coordinateY);
        shop.setPhoneNum(phoneNum);
        shop.setState(state);
        return shop;
    }

	public static void setFields(Order target, PreparedStatement stmt) throws SQLException {
		assert Def.ORDER_FIELDS.length == 10;
        stmt.setString(1, target.getNum());
        stmt.setString(2, target.getAddress());
        stmt.setDouble(3, target.getPriceSum());
        DBUtil.setCalendar(stmt, 4, target.getCreatetime());
        stmt.setInt(5, (int) target.getUserId());
        stmt.setInt(6, (int) target.getShopId());
        stmt.setInt(7, target.getReviewLevel());
        stmt.setString(8, target.getReviewdetail());
        stmt.setBoolean(9, target.isReviewFlag());
        stmt.setInt(10, target.getState());
		
	}
	static Order parseOrder(ResultSet rs) throws SQLException {
        assert Def.ORDER_FIELDS.length == 10;
        String[] fields = Def.ORDER_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        String num = DBUtil.getString(rs, fields[0]);
        String address = DBUtil.getString(rs, fields[1]);
        double priceSum = DBUtil.getFloat(rs, fields[2]);
        Calendar createtime = DBUtil.getCalendar(rs, fields[3]);
        long userId = DBUtil.getLong(rs, fields[4]);
        long shopId = DBUtil.getLong(rs, fields[5]);
        int reviewLevel = DBUtil.getInt(rs, fields[6]);
        String reviewdetail = DBUtil.getString(rs, fields[7]);
        boolean reviewFlag = DBUtil.getBoolean(rs, fields[8]);
        int state = DBUtil.getInt(rs, fields[9]);

        Order order = new Order();
        order.setId(id);
        order.setNum(num);
        order.setAddress(address);
        order.setPriceSum(priceSum);
        order.setCreatetime(createtime);
        order.setUserId(userId);
        order.setShopId(shopId);
        order.setReviewLevel(reviewLevel);
        order.setReviewdetail(reviewdetail);
        order.setReviewFlag(reviewFlag);
        order.setState(state);
        return order;
    }

	public static void setFields(Goods target, PreparedStatement stmt) throws SQLException {
		assert Def.GOODS_FIELDS.length == 5;
        stmt.setString(1, target.getName());
        stmt.setInt(2, (int) target.getShopId());
        stmt.setDouble(3, target.getPrice());
        stmt.setString(4, target.getLogo());
        stmt.setInt(5, target.getState());
	}
	static Goods parseGoods(ResultSet rs) throws SQLException {
        assert Def.GOODS_FIELDS.length == 5;
        String[] fields = Def.GOODS_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        String name = DBUtil.getString(rs, fields[0]);
        long shopId = DBUtil.getInt(rs, fields[1]);
        double price = DBUtil.getFloat(rs, fields[2]);
        String logo = DBUtil.getString(rs, fields[3]);
        int state = DBUtil.getInt(rs, fields[4]);
        
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setShopId(shopId);
        goods.setPrice(price);
        goods.setLogo(logo);
        goods.setState(state);
        return goods;
    }
	
	public static void setFields(Admin target, PreparedStatement stmt) throws SQLException {
		assert Def.ADMIN_FIELDS.length == 3;
        stmt.setString(1, target.getName());
        stmt.setString(2, target.getAccount());
        stmt.setString(3, target.getPw());
	}
	static Admin parseAdmin(ResultSet rs) throws SQLException {
        assert Def.ADMIN_FIELDS.length == 3;
        String[] fields = Def.ADMIN_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        String name = DBUtil.getString(rs, fields[0]);
        String account = DBUtil.getString(rs, fields[1]);
        String pw = DBUtil.getString(rs, fields[2]);
        
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setAccount(account);
        admin.setPw(pw);
        return admin;
    }
	public static void setFields(Consumption target, PreparedStatement stmt) throws SQLException {
		assert Def.CONSUMPTION_FIELDS.length == 4;
		stmt.setInt(1, (int) target.getShopId());
        stmt.setString(2, target.getName());
        stmt.setInt(3, target.getAmount());
        stmt.setInt(4, target.getState());
	}
	static Consumption parseConsumption(ResultSet rs) throws SQLException {
        assert Def.CONSUMPTION_FIELDS.length == 4;
        String[] fields = Def.CONSUMPTION_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        long shopId = DBUtil.getLong(rs, fields[0]);
        String name = DBUtil.getString(rs, fields[1]);
        int amount = DBUtil.getInt(rs, fields[2]);
        int state = DBUtil.getInt(rs, fields[3]);
        
        Consumption consumption = new Consumption();
        consumption.setId(id);
        consumption.setShopId(shopId);
        consumption.setName(name);
        consumption.setAmount(amount);
        consumption.setState(state);
        return consumption;
    }
	
	public static void setFields(Employer target, PreparedStatement stmt) throws SQLException {
		assert Def.EMPLOYER_FIELDS.length == 6;
		stmt.setInt(1, (int) target.getShopId());
        stmt.setString(2, target.getName());
        stmt.setString(3, target.getSex());
        DBUtil.setCalendar(stmt, 4, target.getBirthday());
        stmt.setString(5, target.getDesc());
        stmt.setInt(6, target.getState());
	}
	static Employer parseEmployer(ResultSet rs) throws SQLException {
        assert Def.EMPLOYER_FIELDS.length == 6;
        String[] fields = Def.EMPLOYER_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        long shopId = DBUtil.getLong(rs, fields[0]);
        String name = DBUtil.getString(rs, fields[1]);
        String sex = DBUtil.getString(rs, fields[2]);
        Calendar birthday = DBUtil.getCalendar(rs, fields[3]);
        String desc = DBUtil.getString(rs, fields[4]);
        int state = DBUtil.getInt(rs, fields[5]);
        
        Employer employer = new Employer();
        employer.setId(id);
        employer.setShopId(shopId);
        employer.setName(name);
        employer.setSex(sex);
        employer.setBirthday(birthday);
        employer.setDesc(desc);
        employer.setState(state);
        return employer;
    }
	public static void setFields(RechargeRecord target, PreparedStatement stmt) throws SQLException {
		assert Def.RECHARGE_RECORD_FIELDS.length == 4;
		stmt.setInt(1, (int) target.getUserId());
        DBUtil.setCalendar(stmt, 2, target.getCreatetime());
        stmt.setDouble(3, target.getAmount());
        stmt.setInt(4, target.getState());
	}
	static RechargeRecord parseRechargeRecord(ResultSet rs) throws SQLException {
        assert Def.RECHARGE_RECORD_FIELDS.length == 4;
        String[] fields = Def.RECHARGE_RECORD_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        long userId = DBUtil.getLong(rs, fields[0]);
        Calendar createtime = DBUtil.getCalendar(rs, fields[1]);
        double amount = DBUtil.getFloat(rs, fields[2]);
        int state = DBUtil.getInt(rs, fields[3]);
        
        RechargeRecord rechargeRecord = new RechargeRecord();
        rechargeRecord.setId(id);
        rechargeRecord.setUserId(userId);
        rechargeRecord.setCreatetime(createtime);
        rechargeRecord.setAmount(amount);
        rechargeRecord.setState(state);
        return rechargeRecord;
    }
	
	public static void setFields(OrderDetail target, PreparedStatement stmt) throws SQLException {
		assert Def.ORDER_DETAIL_FIELDS.length == 4;
		stmt.setInt(1, (int) target.getGoodsId());
		stmt.setInt(2, (int) target.getOrderId());
        stmt.setDouble(3, target.getAmount());
        stmt.setInt(4, target.getState());
	}
	static OrderDetail parseOrderDetail(ResultSet rs) throws SQLException {
        assert Def.ORDER_DETAIL_FIELDS.length == 4;
        String[] fields = Def.ORDER_DETAIL_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        long goodsId = DBUtil.getLong(rs, fields[0]);
        long orderId = DBUtil.getLong(rs, fields[1]);
        int amount = DBUtil.getInt(rs, fields[2]);
        int state = DBUtil.getInt(rs, fields[3]);
        
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetail.setGoodsId(goodsId);
        orderDetail.setOrderId(orderId);
        orderDetail.setAmount(amount);
        orderDetail.setState(state);
        return orderDetail;
    }
	
	public static void setFields(ReceiverInfo target, PreparedStatement stmt) throws SQLException {
		assert Def.RECEIVER_INFO_FIELDS.length == 8;
		stmt.setInt(1, (int) target.getUserId());
		stmt.setString(2, target.getRecName());
        stmt.setString(3, target.getRecProv());
        stmt.setString(4, target.getRecCity());
        stmt.setString(5, target.getRecArea());
        stmt.setString(6, target.getRecAddrDetail());
        stmt.setString(7, target.getRecPhonenum());
        stmt.setInt(8, target.getState());
	}
	static ReceiverInfo parseReceiverInfo(ResultSet rs) throws SQLException {
        assert Def.RECEIVER_INFO_FIELDS.length == 8;
        String[] fields = Def.RECEIVER_INFO_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        long userId = DBUtil.getLong(rs, fields[0]);
        String recName = DBUtil.getString(rs, fields[1]);
        String recProv = DBUtil.getString(rs, fields[2]);
        String recCity = DBUtil.getString(rs, fields[3]);
        String recArea = DBUtil.getString(rs, fields[4]);
        String recAddrDetail = DBUtil.getString(rs, fields[5]);
        String recPhonenum = DBUtil.getString(rs, fields[6]);
        int state = DBUtil.getInt(rs, fields[7]);
        
        ReceiverInfo receiverInfo = new ReceiverInfo();
        receiverInfo.setId(id);
        receiverInfo.setUserId(userId);
        receiverInfo.setRecName(recName);
        receiverInfo.setRecProv(recProv);
        receiverInfo.setRecCity(recCity);
        receiverInfo.setRecArea(recArea);
        receiverInfo.setRecAddrDetail(recAddrDetail);
        receiverInfo.setRecPhonenum(recPhonenum);
        receiverInfo.setState(state);
        return receiverInfo;
    }
	
	public static void setFields(GoodsImg target, PreparedStatement stmt) throws SQLException {
		assert Def.GOODS_IMG_FIELDS.length == 4;
		stmt.setInt(1, (int) target.getGoodsId());
		stmt.setString(2, target.getImgUrl());
        stmt.setString(3, target.getImgDesc());
        stmt.setInt(4, target.getState());
	}
	
	static GoodsImg parseGoodsImg(ResultSet rs) throws SQLException {
        assert Def.GOODS_IMG_FIELDS.length == 4;
        String[] fields = Def.GOODS_IMG_FIELDS;
        
        long id = DBUtil.getLong(rs, Def.F_ID);
        long goodsId = DBUtil.getLong(rs, fields[0]);
        String imgUrl = DBUtil.getString(rs, fields[1]);
        String imgDesc = DBUtil.getString(rs, fields[2]);
        int state = DBUtil.getInt(rs, fields[3]);
        
        GoodsImg goodsImg = new GoodsImg();
        goodsImg.setId(id);
        goodsImg.setGoodsId(goodsId);
        goodsImg.setImgUrl(imgUrl);
        goodsImg.setImgDesc(imgDesc);
        goodsImg.setState(state);
        return goodsImg;
    }
	
	
	
	
	
}

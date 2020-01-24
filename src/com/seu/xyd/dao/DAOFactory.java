package com.seu.xyd.dao;


import com.seu.xyd.dao.mysql.AdminDAOImpl;
import com.seu.xyd.dao.mysql.ConsumptionDAOImpl;
import com.seu.xyd.dao.mysql.EmployerDAOImpl;
import com.seu.xyd.dao.mysql.GoodsDAOImpl;
import com.seu.xyd.dao.mysql.GoodsImgDAOImpl;
import com.seu.xyd.dao.mysql.OrderDAOImpl;
import com.seu.xyd.dao.mysql.OrderDetailDAOImpl;
import com.seu.xyd.dao.mysql.ReceiverInfoDAOImpl;
import com.seu.xyd.dao.mysql.RechargeRecordDAOImpl;
import com.seu.xyd.dao.mysql.ShopDAOImpl;
import com.seu.xyd.dao.mysql.UserDAOImpl;

public class DAOFactory {
    final static String KEY = "DAO";

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
    public static ShopDAO getShopDAO() {
        return new ShopDAOImpl();
    }
    public static OrderDAO getOrderDAO() {
        return new OrderDAOImpl();
    }
    public static GoodsDAO getGoodsDAO() {
        return new GoodsDAOImpl();
    }
    public static AdminDAO getAdminDAO() {
        return new AdminDAOImpl();
    }
    public static EmployerDAO getEmployerDAO() {
        return new EmployerDAOImpl();
    }
    public static OrderDetailDAO getOrderDetailDAO() {
        return new OrderDetailDAOImpl();
    }
    public static ConsumptionDAO getConsumptionDAO() {
        return new ConsumptionDAOImpl();
    }
    public static RechargeRecordDAO getRechargeRecordDAO() {
        return new RechargeRecordDAOImpl();
    }
    public static ReceiverInfoDAO getReceiverInfoDAO() {
        return new ReceiverInfoDAOImpl();
    }
    public static GoodsImgDAO getGoodsImgDAO() {
        return new GoodsImgDAOImpl();
    }



    public static void clearDB() throws Exception {
        UserDAO uDao = DAOFactory.getUserDAO();

        uDao.deleteAllDataONLYFORTEST();
    }

    public static void installInitData() throws Exception {
       // UserDAO uDao = DAOFactory.getUserDAO();
        
//        DHStaff admin = new DHStaff();
//        admin.setName("管理员");
//        admin.setMobile("18000000000");
//        admin.setPw("12345");
//        admin.setRole(Role.DH);
//        long uid = uDao.insertUser(admin);
//        admin.setId(uid);
//        uDao.insertDHStaff(admin);
    }
    
}

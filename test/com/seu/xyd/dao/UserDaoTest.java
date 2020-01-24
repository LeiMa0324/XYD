package com.seu.xyd.dao;

import java.util.Calendar;

import org.junit.Test;

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
import com.seu.xyd.logic.UserLogic;
import com.tn17.mysql.DBProcessException;
import com.tn17.util.TimeUtil;

public class UserDaoTest {

	@Test
	public void testDeleteAllData() throws DBProcessException{
		final UserDAO uDao = DAOFactory.getUserDAO();
		uDao.deleteAllDataONLYFORTEST();
	}
	
	
	@Test
    public void testInsertUser() throws Exception {
		final UserDAO uDao = DAOFactory.getUserDAO();
		
		User user = new User();
		user.setAccount("admin");
		user.setPw("12345");
		user.setEmail("12345@qq.com");
		user.setBalance(0);
		user.setBunusFlag(false);
		user.setPhoneNum("1311231312");
		user.setState(0);
		
		uDao.insertUser(user);
    }
	@Test
    public void testSelectUser() throws Exception {
		final UserDAO uDao = DAOFactory.getUserDAO();
		User user = uDao.selectUserByAccount("admin");
		System.out.println(user.toString());
		
    }
	@Test
    public void testInsertAdmin() throws Exception {
		final AdminDAO aDao = DAOFactory.getAdminDAO();
		
		Admin admin = new Admin();
		admin.setAccount("admin");
		admin.setName("管理员");
		admin.setPw("12345");
		
		aDao.insertAdmin(admin);
    }
	@Test
    public void testGetAdmin() throws Exception {
		final AdminDAO aDao = DAOFactory.getAdminDAO();
		Admin admin = aDao.selectAdminByAccount("admin");
		System.out.println(admin.toString());
    }
	@Test
    public void testInsertShop() throws Exception {
		final ShopDAO sDao = DAOFactory.getShopDAO();
		
		Shop shop = new Shop();
		shop.setName("七七洗衣店");
		shop.setAccount("qiqi");
		shop.setPw("12345");
		shop.setDesc("这里是描述数据。。。。。");
		shop.setImg("test.jpg");
		shop.setAddrProvince("江苏省");
		shop.setAddrCity("苏州市");
		shop.setAddrArea("吴中区");
		shop.setAddrDesc("独墅湖高教区");
		shop.setCoordinateX(123.121);
		shop.setCoordinateY(123.121);
		shop.setPhoneNum("1324342w32");
		shop.setState(0);
		
		sDao.insertShop(shop);
    }
	@Test
    public void testGetShop() throws Exception {
		final ShopDAO sDao = DAOFactory.getShopDAO();
		Shop shop = sDao.selectShopByAccount("qiqi");
		System.out.println(shop.toString());
    }
	@Test
    public void testInsertRechargeRecord() throws Exception {
		final RechargeRecordDAO rDao = DAOFactory.getRechargeRecordDAO();
		
		RechargeRecord rechargeRecord = new RechargeRecord();
		rechargeRecord.setUserId(1);
		rechargeRecord.setAmount(120.00);
		rechargeRecord.setCreatetime(Calendar.getInstance());
		rechargeRecord.setState(0);
		
		rDao.insertRechargeRecord(rechargeRecord);
    }
	
	@Test
    public void testGetRechargeRecord() throws Exception {
		final RechargeRecordDAO rDao = DAOFactory.getRechargeRecordDAO();
		RechargeRecord []rechargeRecords = rDao.selectRechargeRecordByUserId(1,1);
		for(RechargeRecord rechargeRecord:rechargeRecords){
			System.out.println(rechargeRecord.toString());
		}
    }
	
	@Test
    public void testInsertOrderDetail() throws Exception {
		final OrderDetailDAO odDao = DAOFactory.getOrderDetailDAO();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setGoodsId(1);
		orderDetail.setOrderId(1);
		orderDetail.setAmount(2);
		orderDetail.setState(0);
		
		odDao.insertOrderDetail(orderDetail);
    }
	
	@Test
    public void testGetOrderDetail() throws Exception {
		final OrderDetailDAO odDao = DAOFactory.getOrderDetailDAO();
		OrderDetail []OrderDetails = odDao.selectOrderDetailsByOrderId(1);
		for(OrderDetail orderDetail : OrderDetails){
			System.out.println(orderDetail.toString());
		}
    }
	
	@Test
    public void testInsertOrder() throws Exception {
		final OrderDAO oDao = DAOFactory.getOrderDAO();
		
		Order order = new Order();
		order.setNum("DS1212192919");
		order.setAddress("独墅湖高教区东南大学苏州研究院");
		order.setPriceSum(120.00);
		order.setUserId(1);
		order.setShopId(2);
		order.setReviewFlag(false);
		order.setReviewdetail("");
		order.setReviewLevel(2);
		order.setState(1);
		
		oDao.insertOrder(order);
    }
	
	@Test
    public void testGetOrder() throws Exception {
		final OrderDAO oDao = DAOFactory.getOrderDAO();
		Order []Orders = oDao.selectOrdersByShopId(1);
		for(Order order : Orders){
			System.out.println(order.toString());
		}
    }
	
	@Test
    public void testInsertGoods() throws Exception {
		final GoodsDAO gDao = DAOFactory.getGoodsDAO();
		
		Goods goods = new Goods();
		goods.setName("衬衫干洗");
		goods.setShopId(1);
		goods.setPrice(20.00);
		goods.setLogo("321312.jpg");
		goods.setState(0);
		
		gDao.insertGoods(goods);
    }
	@Test
	public void testGetGoods() throws Exception {
		final GoodsDAO gDao = DAOFactory.getGoodsDAO();
		Goods []goodss = gDao.selectGoodssByShopId(1);
		for(Goods goods:goodss){
			System.out.println(goods.toString());
		}
    }
	@Test
    public void testInsertEmployer() throws Exception {
		final EmployerDAO eDao = DAOFactory.getEmployerDAO();
		
		Employer employer = new Employer();
		employer.setShopId(1);
		employer.setName("张三");
		employer.setSex("男");
		employer.setBirthday(Calendar.getInstance());
		employer.setDesc("中流砥柱，优秀员工");
		employer.setState(0);
		
		eDao.insertEmployer(employer);
    }
	
	@Test
	public void testGetEmployer() throws Exception {
		final EmployerDAO eDao = DAOFactory.getEmployerDAO();
		Employer []employers = eDao.selectEmployersByShopId(1);
		for(Employer employer: employers ){
			System.out.println(employer.toString());
		}
    }
	
	@Test
    public void testInsertConsumption() throws Exception {
		final ConsumptionDAO cDao = DAOFactory.getConsumptionDAO();
		
		Consumption consumption = new Consumption();
		consumption.setShopId(1);
		consumption.setName("张三");
		consumption.setAmount(12);
		consumption.setState(0);
		
		cDao.insertConsumption(consumption);
    }
	@Test
	public void testGetConsumption() throws Exception {
		final ConsumptionDAO cDao = DAOFactory.getConsumptionDAO();
		Consumption []consumptions = cDao.selectConsumptionsByShopId(1);
		for(Consumption consumption:consumptions){
			System.out.println(consumption.toString());
		}
    }
	@Test
    public void testInsertGoodsImg() throws Exception {
		final GoodsImgDAO giDao = DAOFactory.getGoodsImgDAO();
		
		GoodsImg goodsImg = new GoodsImg();
		goodsImg.setGoodsId(1);
		goodsImg.setImgDesc("这个商品是个好商品。。。");
		goodsImg.setImgUrl("123123.jpg");
		goodsImg.setState(0);
		
		giDao.insertGoodsImg(goodsImg);
    }
	@Test
	public void testGetGoodsImgs() throws Exception {
		final GoodsImgDAO giDao = DAOFactory.getGoodsImgDAO();
		GoodsImg[] goodsImgs = giDao.selectGoodsImgsByGoodsId(1);
		for(GoodsImg goodsImg: goodsImgs){
			System.out.println(goodsImg.toString());
		}
    }
	@Test
    public void testInsertReceiverInfo() throws Exception {
		final ReceiverInfoDAO riDao = DAOFactory.getReceiverInfoDAO();
		
		ReceiverInfo receiverInfo = new ReceiverInfo();
		receiverInfo.setUserId(2);
		receiverInfo.setRecName("佳林");
		receiverInfo.setRecPhonenum("312341231");
		receiverInfo.setRecProv("江苏省");
		receiverInfo.setRecCity("苏州市");
		receiverInfo.setRecArea("吴中区");
		receiverInfo.setRecAddrDetail("独墅湖高教区");
		receiverInfo.setState(0);
		
		riDao.insertReceiverInfo(receiverInfo);
    }
	@Test
	public void testGetReceiverInfo() throws Exception {
		final ReceiverInfoDAO riDao = DAOFactory.getReceiverInfoDAO();
		ReceiverInfo[] receiverInfos = riDao.selectReceiverInfosByUserId(1);
		for(ReceiverInfo receiverInfo : receiverInfos){
			System.out.println(receiverInfo.toString());
		}
    }
}

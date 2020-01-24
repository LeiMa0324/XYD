package com.seu.xyd.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.seu.xyd.data.Goods;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.seu.xyd.data.Employer;
import com.seu.xyd.data.XYDErrors;
import com.seu.xyd.logic.LogicUtil;
import com.seu.xyd.logic.OrderLogic;
import com.seu.xyd.logic.ShopLogic;
import com.seu.xyd.logic.UserLogic;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;
import com.tn17.util.ArrayUtil;

/**
 * Servlet implementation class userServlet
 */
public class ShopServlet extends XYDServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418032213105965975L;
    final ShopLogic sL = ShopLogic.getInstance();
    

	@Override
	String process(HttpServletRequest request) throws LogicException,
			DBProcessException, ServletException {
		Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element result = root.addElement("result");
        
        XYDWebOP op = XYDWebOP.valueOfName(UIUtil.getParam(request, XYDWebParam.OP));
        switch (op) {
        case SIGIN: {
            sigin(request, result);
            break;
        }
        case REGISTER:{
        	register(request,result);
        	break;
        }
        case REGISTER2:{
        	register2(request,result);
        	break;
        }
        case GET_GOODS_LIST_BY_SHOP_ID: {
            getGoodsListByShopId(request, result);
            break;
        }
        case GET_EMPLOYER_LIST_BY_SHOP_ID_AND_KEYWORD: {
        	getEmployerListByShopIdAndKeyword(request, result);
            break;
        }
        
        case UPDATA_GOODS_INFO_BY_GOODSID://程君
        {
        	updatagoodsinfobygoodsid(request,result);
        	break;
        }
        case GET_GOODS_WITH_PAGE:
        {
        	getGoodsWithPage(request,result);
        	break;
        	
        }
        case DELETE_GOODS_BY_GOODSID:
        {
        	deleteGoodsByGoodsId(request,result);
        	break;
        }
        case GET_SHOP_INFO:
        {
        	getshopinfo(request,result);
        	break;
        }
        case ADD_GOOD_TO_SHOP://分割线
        {
        	addgoodtoshop(request,result);
        	break;
        }
        case GET_NEARBY_SHOP:{
        	getNearbyShop(request,result);
        	break;
        }
        case GET_GOODS_LIST_BY_COOKIE:{
        	getGoodsListByCookie(request,result);
        	break;
        }
        case GET_SHOP_LIST_BY_KEYWORD://张雅南
        {
        	getShopListByKeyword(request,result);
        	break;
        	
        }
        case GET_SHOP_WITH_ADMIN://张雅南
        {
        	GetShopWithAdmin(request,result);
        	break;
        	
        }
        case GET_SHOP_BY_ID://张雅南
        {
        	GetShopById(request,result);
        	break;
        	
        }
        case UPDATA_SHOP_INFO:
        {
        	updatashopinfo(request,result);
        }
        default:
            assert false:"no such op"+op.getName();
            break;
        }
        
        return result.asXML();
	}


	private void getGoodsListByCookie(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String cookieString = UIUtil.getParam(request, XYDWebParam.COOKIE_STRING);
		int goodsIds[] = ArrayUtil.parseIntArray(cookieString, ",");
		String goodsIdArrStr = ArrayUtil.parseStringOfIntArrayNoSpace(goodsIds, ",");
		if(goodsIds.length==0){
			goodsIdArrStr = "-1";
		}
		Goods [] goodss = sL.getGoodsByGoodsIdArrStr(goodsIdArrStr);
		
		Element shopElement = null ;
		Shop shop = null;
		if(goodss.length>0){
			shopElement = result.addElement("shop");
			shop = sL.getShopById((int) goodss[0].getShopId());
			shopElement.addAttribute("id", shop.getId()+"");
			shopElement.addAttribute("name", shop.getName());
			shopElement.addAttribute("account", shop.getAccount());
		}
		
		for(int i=0;i<goodss.length;i++){
			Goods goods = goodss[i];
			if(goods.getShopId()==shop.getId()){
				Element e = shopElement.addElement("goods_"+shop.getId());
				UIUtil.appendGoodsWithXML(goods, e);
			}else{
				shopElement = result.addElement("shop");
				shop = sL.getShopById((int) goodss[i].getShopId());
				shopElement.addAttribute("id", shop.getId()+"");
				shopElement.addAttribute("name", shop.getName());
				shopElement.addAttribute("account", shop.getAccount());
				
				Element e = shopElement.addElement("goods_"+shop.getId());
				UIUtil.appendGoodsWithXML(goods, e);
			}
			
		}
		
	}

	private void register2(HttpServletRequest request, Element result) throws ServletException, DBProcessException, LogicException {
		float lng = UIUtil.getParamInFloat(request, XYDWebParam.LNG);
		float lat = UIUtil.getParamInFloat(request, XYDWebParam.LAT);
		String addrProv = UIUtil.getParam(request, XYDWebParam.ADDR_PROV);
		String addrCity = UIUtil.getParam(request, XYDWebParam.ADDR_CITY);
		String addrArea = UIUtil.getParam(request, XYDWebParam.ADDR_AREA);
		String addrDesc = UIUtil.getParam(request, XYDWebParam.ADDR_DESC);
		
		Shop shop = UIUtil.getLogonShop(request.getSession());
		shop.setAddrProvince(addrProv);
		shop.setAddrCity(addrCity);
		shop.setAddrArea(addrArea);
		shop.setAddrDesc(addrDesc);
		shop.setCoordinateX(lng);
		shop.setCoordinateY(lat);
		sL.updateShop(shop);
	}

	private void register(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		String account = UIUtil.getParam(request, XYDWebParam.ACCOUNT);
		String name = UIUtil.getParam(request, XYDWebParam.NAME);
		String pw = UIUtil.getParam(request, XYDWebParam.PW);
		String phone = UIUtil.getParam(request, XYDWebParam.PHONE);
		String desc = UIUtil.getParam(request, XYDWebParam.DESC);
		Shop shop = new Shop();
		shop.setAccount(account);
		shop.setName(name);
		shop.setPw(pw);
		shop.setPhoneNum(phone);
		shop.setDesc(desc);
		long id = sL.insertShop(shop);
		shop.setId(id);
		HttpSession session = request.getSession(false);
		session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_ROLE, UIUtil.SESSION_ATTRIBUTE_KEY_FOR_SHOP);
        session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_SHOP, shop);
        
	}
	private void sigin(HttpServletRequest request, Element result) throws ServletException, LogicException, DBProcessException {
		// 
		String account = UIUtil.getParam(request, XYDWebParam.ACCOUNT);
		String pw = UIUtil.getParam(request, XYDWebParam.PW);
		Shop shop = sL.signIn(account);
		
		if(shop.getPw().equals(pw)){
			HttpSession session = request.getSession(false);
			session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_ROLE, UIUtil.SESSION_ATTRIBUTE_KEY_FOR_SHOP);
	        session.setAttribute(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_SHOP, shop);
	        
		}else{
			throw LogicUtil.createException(XYDErrors.SIGN_IN_FAIL);
		}
	}

	private void getNearbyShop(HttpServletRequest request, Element result) throws ServletException, DBProcessException {
		float lng = UIUtil.getParamInFloat(request, XYDWebParam.LNG);
		float lat = UIUtil.getParamInFloat(request, XYDWebParam.LAT);
		Shop []shops = sL.getShopListByLngAndLat(lng,lat);
		for(Shop shop :shops){
			UIUtil.appendShopToXML(shop, result);
		}
	}


	private void getGoodsListByShopId(HttpServletRequest request, Element result) throws ServletException, DBProcessException 
	{
		int id = UIUtil.getParamInInt(request, XYDWebParam.ID);
		Shop shop = sL.getShopById(id);
		Goods[] goodss = sL.getGoodsListByShopId(id);
		UIUtil.appendShopToXML(shop, result);
		for(Goods goods : goodss){
			UIUtil.appendGoodsToXML(goods, result);
		}
		
	}
	
	private void getGoodsWithPage(HttpServletRequest request, Element result) throws ServletException, DBProcessException 
	{
		Shop shop = UIUtil.getLogonShop(request.getSession());
		int page = UIUtil.getParamInInt(request, XYDWebParam.PAGE);
		Goods[] goodss = sL.getGoodsListByShopIdWithPage(shop.getId(),page);
		int total = sL.getGoodsCountByShopId(shop.getId());
		result.addAttribute("total", total+"");
	
		for(Goods goods : goodss)
		{
			UIUtil.appendGoodsToXML(goods, result);
		}
		
	}
	
	private void updatagoodsinfobygoodsid(HttpServletRequest request, Element result) throws ServletException, DBProcessException
	{
		String name = UIUtil.getParam(request, XYDWebParam.GOODSNAME);
		double price =  UIUtil.getParamInFloat(request, XYDWebParam.GOODPRICE);
		String imageString =  UIUtil.getParam(request, XYDWebParam.IMAGE);
		int id =  UIUtil.getParamInInt(request, XYDWebParam.ID);
		Goods goods =sL.getGoodsByGoodsId(id);
		
		goods.setLogo(imageString);
		goods.setPrice(price);
		goods.setName(name);
		sL.insertGood(goods);
		result.addAttribute("result", "success");
	}
	
	public void addgoodtoshop(HttpServletRequest request, Element result) throws ServletException, DBProcessException
	{
		String name = UIUtil.getParam(request, XYDWebParam.GOODSNAME);
		double price =  UIUtil.getParamInFloat(request, XYDWebParam.GOODPRICE);
		String imageString =  UIUtil.getParam(request, XYDWebParam.IMAGE);
		Shop shop = UIUtil.getLogonShop(request.getSession());
		Goods goods =new Goods();
		goods.setShopId(shop.getId());
		goods.setLogo(imageString);
		goods.setPrice(price);
		goods.setName(name);
		sL.insertGood(goods);
		result.addAttribute("result", "success");
	}
	
	public void	deleteGoodsByGoodsId(HttpServletRequest request, Element result) throws  DBProcessException, ServletException
	{
		String goodsids = UIUtil.getParam(request, XYDWebParam.GOODSIDS);
		int []idGoodsArray=  ArrayUtil.parseIntArray(goodsids, ",");
		for (int i=0;i<idGoodsArray.length;i++)
		{
			
			sL.deleteGoodsWithId(idGoodsArray[i]);
		}
		result.addAttribute("result", "success");
	}
	
	public void getshopinfo(HttpServletRequest request, Element result) throws ServletException
	{
		Shop shop = UIUtil.getLogonShop(request.getSession());
		UIUtil.appendShopToXML(shop, result);
	}
	
	public void updatashopinfo(HttpServletRequest request, Element result) throws ServletException, DBProcessException, LogicException 
	{
		Shop shop = UIUtil.getLogonShop(request.getSession());
		String name = UIUtil.getParam(request, XYDWebParam.NAME);
		String phone = UIUtil.getParam(request, XYDWebParam.PHONE);
		String img = UIUtil.getParam(request, XYDWebParam.IMAGE);
		String desc = UIUtil.getParam(request, XYDWebParam.DESC);
		shop.setName(name);
		shop.setPhoneNum(phone);
		shop.setImg(img);
		shop.setDesc(desc);
		sL.updateShop(shop);
		result.addAttribute("result", "success");
	}
	
		//张雅南-根据id获取商铺信息
	private void GetShopById(HttpServletRequest request, Element result)throws ServletException, DBProcessException
	{
		int id = UIUtil.getParamInInt(request, XYDWebParam.ID);
		Shop shop = sL.getShopById(id);
		UIUtil.appendShopToXML(shop, result);

	}
	//张雅南-按关键字搜索用户
	private void getShopListByKeyword(HttpServletRequest request, Element result) throws ServletException, DBProcessException
	{

		String keywordString = UIUtil.getParam(request, XYDWebParam.SEARCH_USER_KEYWORD);
		System.out.println(keywordString);
		int page = UIUtil.getParamInInt(request,  XYDWebParam.USER_PAGE);
		Shop []shop = sL.getShopsWithKeyWord(keywordString, page);

		for(int i =0;i<shop.length;i++)
		{
			UIUtil.appendShopToXML(shop[i], result);
			}
		}
	//张雅南-获取所有用户
	private void GetShopWithAdmin(HttpServletRequest request, Element result)throws ServletException, DBProcessException
	{

		Shop[] shops = sL.getShopList();  
		for(Shop shop : shops){
			UIUtil.appendShopToXML(shop, result);
		}
	}
	
	
	private void getEmployerListByShopIdAndKeyword(HttpServletRequest request, Element result) throws ServletException, DBProcessException{
		// TODO Auto-generated method stub
		String empname_keyword= UIUtil.getParam(request, XYDWebParam.EMPNAME_KEYWORD);
//		int shopId=UIUtil.getParamInInt(request, XYDWebParam.ID);
		int page=UIUtil.getParamInInt(request, XYDWebParam.PAGE);
		int shopId = 2;
		Employer [] employers = sL.getEmployerListByShopIdAndKeyword(shopId,empname_keyword,page);
		int total = sL.getEmployerCountByShopId(shopId);
		result.addAttribute("total", total+"");
		for(Employer employer : employers){
			UIUtil.appendEmployersWithXML(employer, result);
		}
		
	}
	
}

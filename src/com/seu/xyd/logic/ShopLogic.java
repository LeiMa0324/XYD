package com.seu.xyd.logic;

import javax.servlet.ServletException;
import javax.sql.rowset.serial.SerialException;

import com.seu.xyd.dao.DAOFactory;
import com.seu.xyd.dao.GoodsDAO;
import com.seu.xyd.dao.GoodsImgDAO;
import com.seu.xyd.dao.OrderDAO;
import com.seu.xyd.dao.ShopDAO;
import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.Employer;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.GoodsImg;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.seu.xyd.data.XYDErrors;
import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.NoSuchCase;
public class ShopLogic 
{
    private static ShopLogic instance = null;
    private final ShopDAO sDao = DAOFactory.getShopDAO();
    private final GoodsDAO gDao = DAOFactory.getGoodsDAO();
    private final GoodsImgDAO giDao = DAOFactory.getGoodsImgDAO();

    private ShopLogic() {
        // lock it
    }

    public synchronized static ShopLogic getInstance() {
        if (instance == null) {
            instance = new ShopLogic();
        }
        return instance;
    }

	public Goods[] getGoodsListByShopId(int id) throws DBProcessException
	{
		return gDao.selectGoodssByShopId(id);
	}

	public Goods[] getGoodsListByShopIdWithPage(long id ,int page) throws DBProcessException
	{
		return gDao.getGoodsListByShopIdWithPage(id,page);
	}
	public Goods getGoodsByGoodsId(long id) throws DBProcessException, ServletException {
		try {
			Goods goods = gDao.selectGoods(id);
			GoodsImg []goodsImgs = giDao.selectGoodsImgsByGoodsId(goods.getId());
			goods.setGoodImgs(goodsImgs);
			return goods;
		} catch (NoSuchCase e) {
			throw new ServletException("数据异常");
		}
	}


	public long insertShop(Shop shop) throws DBProcessException {
		return sDao.insertShop(shop);
	}

	public Shop[] getShopListByLngAndLat(float lng, float lat) throws DBProcessException {
		return sDao.getShopListByLngAndLat(lng,lat);
	}

	public Shop signIn(String account) throws DBProcessException, LogicException {
		try {
			return sDao.selectShopByAccount(account);
		} catch (NoSuchCase e) {
			throw LogicUtil.createException(XYDErrors.NO_SUCH_USER);
		}
	}

	public void updateShop(Shop shop) throws DBProcessException, LogicException {
		try {
			sDao.updateShop(shop);
		} catch (NoSuchCase e) {
			throw LogicUtil.createException(XYDErrors.NO_SUCH_USER);
		}
		
	}

	public int getGoodsCountByShopId(long id) throws DBProcessException 
	{
		return gDao.getGoodsCountByShopId(id); 
	}

	public Shop getShopById(int id) throws DBProcessException, ServletException {
		try {
			return sDao.selectShop(id);
		} catch (NoSuchCase e) {
			throw new ServletException("数据异常");
		}
	}

	public Goods[] getGoodsByGoodsIdArrStr(String goodsIdArrStr) throws DBProcessException {
		return gDao.getGoodsByGoodsIdArrStr(goodsIdArrStr);
	}

	

	public void updateGoods(Goods goods) throws DBProcessException, ServletException 
	{
		try 
		{
			gDao.updateGoods(goods);
		} catch (NoSuchCase e) {
			throw new ServletException("商品不存在");
		}
	}
	public long insertGood(Goods good) throws DBProcessException 
	{
		return sDao.insertGoods(good);
	}
	public void deleteGoodsWithId(int id) throws DBProcessException, ServletException
	{
		try 
		{
		sDao.DeleteGoodByid(id);
		} catch (NoSuchCase e) {
			throw new ServletException("商品不存在");
		}
		
	}	
	//张雅南--按关键字搜索商户
		public Shop[] getShopsWithKeyWord(String keyWord, int page) throws DBProcessException {
			return sDao.getShopListByShopIdWithPage( keyWord,page);
		}

	public Shop[] getShopList() throws DBProcessException {
		Shop[] shops = sDao.selectShops();
		return shops;
	}

	//计算员工总个数（分页用）
	public int getEmployerCountByShopId(int shopId) {
		// TODO Auto-generated method stub
		return sDao.getEmployerCountByShopId(shopId);
	}


	//根据shoid和keyword检索员工
	public Employer[] getEmployerListByShopIdAndKeyword(int shopId, String empname_keyword, int page) {
		// TODO Auto-generated method stub
		return sDao.getEmployerListByShopIdAndKeyword(shopId,empname_keyword,page);
	}
	



   
}

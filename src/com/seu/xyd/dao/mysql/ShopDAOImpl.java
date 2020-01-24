package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.ShopDAO;
import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.Admin;
import com.seu.xyd.data.Employer;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.Shop;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.IllegalDBStateException;
import com.tn17.mysql.NoSuchCase;

public class ShopDAOImpl implements ShopDAO{

	@Override
	public void deleteAllDataONLYFORTEST() throws DBProcessException
	{

	
	}
	@Override
	public void DeleteGoodByid(int id) throws DBProcessException, NoSuchCase
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "delete from %s where id=?";
        sql = String.format(sql, Def.T_GOODS);
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rlt = stmt.executeUpdate();
        } catch (SQLException e) 
        {
            DBUtil.processSQLException(e, Def.T_GOODS);
        } 
        finally 
        {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}
	
	@Override
	public  long insertGoods(Goods goods) throws DBProcessException
	{
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_GOODS, Def.GOODS_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(goods, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}
	
	@Override
	public long insertShop(Shop shop) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_SHOP, Def.SHOP_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(shop, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}

	@Override
	public Shop selectShop(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_SHOP, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	Shop shop = UserDAOUtil.parseShop(rs);
                assert !rs.next();
                return shop;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public Shop selectShopByAccount(String account) throws DBProcessException,
			NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_SHOP, Def.SHOP_FIELDS[1]);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, account);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	Shop shop = UserDAOUtil.parseShop(rs);
                assert !rs.next();
                return shop;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public void deleteShop(long id) throws DBProcessException, NoSuchCase
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "delete from %s where id=?";
        sql = String.format(sql, Def.T_SHOP);
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rlt = stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
	}

	@Override
	public void updateShop(Shop Shop) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_SHOP, Def.SHOP_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(Shop, stmt);
            stmt.setLong(Def.SHOP_FIELDS.length + 1, Shop.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public Shop[] selectShops() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_SHOP);
 
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Shop> rlt = new ArrayList<Shop>();
            while (rs.next()) {
            	Shop one = UserDAOUtil.parseShop(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Shop[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	

	@Override
	public Shop[] getShopListByLngAndLat(float lng, float lat) throws DBProcessException 
	{
		// TODO Auto-generated method stub
		//select *,((120.753216-shop_coordinate_x)*(120.753216-shop_coordinate_x)+
				//(31.275702-shop_coordinate_y)*(31.275702-shop_coordinate_y)) as sum from t_shop ORDER BY sum limit 2
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select *,((?-shop_coordinate_x)*(?-shop_coordinate_x)+"
        		+ "(?-shop_coordinate_y)*(?-shop_coordinate_y)) as sum from %s ORDER BY sum limit 10";
        sql = String.format(sql, Def.T_SHOP);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, lng);
            stmt.setFloat(2, lng);
            stmt.setFloat(3, lat);
            stmt.setFloat(4, lat);
            rs = stmt.executeQuery();
            List<Shop> rlt = new ArrayList<Shop>();
            while (rs.next()) {
            	Shop one = UserDAOUtil.parseShop(rs);
            	double length = DBUtil.getFloat(rs, "sum");
            	one.setLength(Math.sqrt(length)*111);
                rlt.add(one);
            }
            return rlt.toArray(new Shop[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_SHOP);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	public Shop[] getShopListByShopIdWithPage(String keyWord, int page) throws DBProcessException
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pageSize = 8;
        int start = (page-1)*pageSize;

        String sql = "select * from %s where %s like ?  group by id limit ?,?";
        sql = String.format(sql, Def.T_SHOP,Def.SHOP_FIELDS[1]);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            String keywordString = new String("%"+keyWord+"%");
            stmt.setString(1, keywordString);
            stmt.setInt(2, start);
            stmt.setInt(3, pageSize);
            rs = stmt.executeQuery();
            List<Shop> rlt = new ArrayList<Shop>();
            while (rs.next()) {
            	Shop one = UserDAOUtil.parseShop(rs);
                rlt.add(one);
            }
            return rlt.toArray(new Shop[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	
	
	}
	@Override
	public int getEmployerCountByShopId(int shopId) {
		
		return 0;
	}
	@Override
	public Employer[] getEmployerListByShopIdAndKeyword(int shopId, String empname_keyword, int page) {
		// TODO Auto-gene 	rated method stub
		return null;
	}

}

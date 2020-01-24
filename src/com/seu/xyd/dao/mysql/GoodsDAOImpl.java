package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.GoodsDAO;
import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.IllegalDBStateException;
import com.tn17.mysql.NoSuchCase;

public class GoodsDAOImpl implements GoodsDAO{

	@Override
	public void deleteAllDataONLYFORTEST() throws DBProcessException {

		
	}

	@Override
	public long insertGoods(Goods goods) throws DBProcessException {
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
	public Goods selectGoods(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_GOODS, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	Goods goods = UserDAOUtil.parseGoods(rs);
                assert !rs.next();
                return goods;
            }
            throw new NoSuchCase();
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
	public void deleteGoods(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "delete from %s where id=?";
        sql = String.format(sql, Def.T_GOODS);
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rlt = stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
	}

	@Override
	public void updateGoods(Goods goods) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_GOODS, Def.GOODS_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(goods, stmt);
            stmt.setLong(Def.GOODS_FIELDS.length + 1, goods.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public Goods[] selectGoodss() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_GOODS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Goods> rlt = new ArrayList<Goods>();
            while (rs.next()) {
            	Goods one = UserDAOUtil.parseGoods(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Goods[0]);
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
	public Goods[] selectGoodssByShopId(long shopId) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_GOODS,Def.F_SHOP_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shopId);
            rs = stmt.executeQuery();
            List<Goods> rlt = new ArrayList<Goods>();
            while (rs.next()) {
            	Goods one = UserDAOUtil.parseGoods(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Goods[0]);
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
	public int getGoodsCountByShopId(long id) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select count(*) as sum from %s where %s=?";
        sql = String.format(sql,Def.T_GOODS,Def.F_SHOP_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return DBUtil.getInt(rs, "sum");
            }else{
            	return 0;
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}

	@Override
	public Goods[] getGoodsListByShopIdWithPage(long id, int page) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pageSize = 8;
        int start = (page-1)*pageSize;

        String sql = "select * from %s where %s=? group by id limit ?,?";
        sql = String.format(sql, Def.T_GOODS,Def.F_SHOP_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setInt(2, start);
            stmt.setInt(3, pageSize);
            rs = stmt.executeQuery();
            List<Goods> rlt = new ArrayList<Goods>();
            while (rs.next()) {
            	Goods one = UserDAOUtil.parseGoods(rs);
                rlt.add(one);
            }
            return rlt.toArray(new Goods[0]);
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
	public Goods[] getGoodsByGoodsIdArrStr(String goodsIdArrStr) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s in (%s) order by %s";
        sql = String.format(sql, Def.T_GOODS,Def.F_ID,goodsIdArrStr,Def.F_SHOP_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Goods> rlt = new ArrayList<Goods>();
            while (rs.next()) {
            	Goods one = UserDAOUtil.parseGoods(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Goods[0]);
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



}

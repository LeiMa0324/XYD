package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.OrderDAO;
import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.Order;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.IllegalDBStateException;
import com.tn17.mysql.NoSuchCase;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public void deleteAllDataONLYFORTEST() throws DBProcessException {

		
	}

	@Override
	public long insertOrder(Order order) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_ORDER, Def.ORDER_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(order, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}

	@Override
	public Order selectOrder(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ORDER, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	Order order = UserDAOUtil.parseOrder(rs);
                assert !rs.next();
                return order;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	

	@Override
	public void deleteOrder(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "delete from %s where id=?";
        sql = String.format(sql, Def.T_ORDER);
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rlt = stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
	}

	@Override
	public void updateOrder(Order order) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_ORDER, Def.ORDER_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(order, stmt);
            stmt.setLong(Def.ORDER_FIELDS.length + 1, order.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public Order[] selectOrders() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_ORDER);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Order> rlt = new ArrayList<Order>();
            while (rs.next()) {
            	Order one = UserDAOUtil.parseOrder(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Order[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}
	
	@Override
	public Order[] selectOrdersByShopId(long shopId) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ORDER,Def.F_SHOP_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shopId);
            rs = stmt.executeQuery();
            List<Order> rlt = new ArrayList<Order>();
            while (rs.next()) {
            	Order one = UserDAOUtil.parseOrder(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Order[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public Order[] selectOrdersByUserId(long userId) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ORDER,Def.F_USER_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, userId);
            rs = stmt.executeQuery();
            List<Order> rlt = new ArrayList<Order>();
            while (rs.next()) {
            	Order one = UserDAOUtil.parseOrder(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Order[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public Order[] selectOrdersByShopIdAndKeyword(long shopId, String keyword, int page) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        keyword = "%"+keyword+"%";
        int pageSize = 10;
        int start = pageSize*(page-1);
        String sql = "select * from %s where %s=? and %s like ? group by id limit ?,?";
        sql = String.format(sql, Def.T_ORDER,Def.F_SHOP_ID,Def.F_ORDER_NUM);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shopId);
            stmt.setString(2, keyword);
            stmt.setInt(3, start);
            stmt.setInt(4, pageSize);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            List<Order> rlt = new ArrayList<Order>();
            while (rs.next()) {
            	Order one = UserDAOUtil.parseOrder(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Order[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	
	//根据shopid和订单状态检索sql
	@Override
	public Order[] selectOrdersByShopIdAndOrderState(long shopId,int orderstate, int page) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pageSize = 10;
        int start = pageSize*(page-1);
        String sql = "select * from %s where %s=? and %s group by id limit ?,?";
        sql = String.format(sql, Def.T_ORDER,Def.F_SHOP_ID,Def.termSupportMinusOne(Def.F_ORDER_STATE, orderstate));
        
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shopId);
            stmt.setInt(2, start);
            stmt.setInt(3, pageSize);
            //System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            List<Order> rlt = new ArrayList<Order>();
            while (rs.next()) {
            	Order one = UserDAOUtil.parseOrder(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Order[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public int getOrderNeedProcessCount(int shopId, int orderState) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select count(*) as sum from %s where %s=? and %s>? and %s<?";
        sql = String.format(sql, Def.T_ORDER,Def.F_SHOP_ID,Def.F_ORDER_STATE,Def.F_ORDER_STATE);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shopId);
            stmt.setInt(2, 0);
            stmt.setInt(3, 3);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	return DBUtil.getInt(rs, "sum");
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}

	@Override
	public int getOrderCountByShopIdAndState(int shopId, int orderState) throws  DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select count(*) as sum from %s where %s=? and %s";
        sql = String.format(sql, Def.T_ORDER,Def.F_SHOP_ID,Def.termSupportMinusOne(Def.F_ORDER_STATE, orderState));

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shopId);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	return DBUtil.getInt(rs, "sum");
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}



}

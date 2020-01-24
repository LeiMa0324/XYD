package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.OrderDetailDAO;
import com.seu.xyd.data.OrderDetail;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public long insertOrderDetail(OrderDetail orderDetail) throws DBProcessException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_ORDER_DETAIL, Def.ORDER_DETAIL_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(orderDetail, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER_DETAIL);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
    }

    @Override
    public OrderDetail selectOrderDetail(long id) throws DBProcessException, NoSuchCase {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ORDER_DETAIL, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                OrderDetail orderDetail = UserDAOUtil.parseOrderDetail(rs);
                assert !rs.next();
                return orderDetail;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER_DETAIL);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
    }

	@Override
	public void deleteAllDataONLYFORTEST() throws DBProcessException {
		Connection conn = null;
        try {
            conn = ConnUtil.getConnection();
            for (String tableName : UserDAOUtil.tables) {
                DBUtil.clearTableAndResetAutoIncresement(conn, tableName);
            }
        } finally {
            ConnUtil.closeConnection(conn);
        }
	}


	@Override
	public void deleteOrderDetail(long id) throws DBProcessException, NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String sql = "delete from %s where id=?";
	        sql = String.format(sql, Def.T_ORDER_DETAIL);
	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setLong(1, id);
	            int rlt = stmt.executeUpdate();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_ORDER_DETAIL);
	        } finally {
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
		
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_ORDER_DETAIL, Def.ORDER_DETAIL_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(orderDetail, stmt);
            stmt.setLong(Def.ORDER_DETAIL_FIELDS.length + 1, orderDetail.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER_DETAIL);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}



	@Override
	public OrderDetail[] selectOrderDetailsByOrderId(long orderId) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ORDER_DETAIL,Def.ORDER_DETAIL_FIELDS[1]);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (int) orderId);
            rs = stmt.executeQuery();
            List<OrderDetail> rlt = new ArrayList<OrderDetail>();
            while (rs.next()) {
            	OrderDetail one = UserDAOUtil.parseOrderDetail(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new OrderDetail[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER_DETAIL);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public OrderDetail getOrderDetail(int id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ORDER_DETAIL, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	OrderDetail one = UserDAOUtil.parseOrderDetail(rs);
            	return one;
            }else{
            	throw new NoSuchCase();
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ORDER_DETAIL);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}




}

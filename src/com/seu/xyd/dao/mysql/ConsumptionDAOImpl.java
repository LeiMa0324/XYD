package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.ConsumptionDAO;
import com.seu.xyd.data.Consumption;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class ConsumptionDAOImpl implements ConsumptionDAO{

    @Override
    public long insertConsumption(Consumption consumption) throws DBProcessException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_CONSUMPTION, Def.CONSUMPTION_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(consumption, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_CONSUMPTION);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
    }

    @Override
    public Consumption selectConsumption(long id) throws DBProcessException, NoSuchCase {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_CONSUMPTION, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Consumption consumption = UserDAOUtil.parseConsumption(rs);
                assert !rs.next();
                return consumption;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_CONSUMPTION);
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
	public void deleteConsumption(long id) throws DBProcessException, NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String sql = "delete from %s where id=?";
	        sql = String.format(sql, Def.T_CONSUMPTION);
	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setLong(1, id);
	            int rlt = stmt.executeUpdate();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_CONSUMPTION);
	        } finally {
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
		
	}

	@Override
	public void updateConsumption(Consumption consumption) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_CONSUMPTION, Def.CONSUMPTION_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(consumption, stmt);
            stmt.setLong(Def.CONSUMPTION_FIELDS.length + 1, consumption.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_CONSUMPTION);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public Consumption[] selectConsumptionsByShopId(long shopId) throws DBProcessException{
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        String sql = "select * from %s where %s=?";
	        sql = String.format(sql, Def.T_CONSUMPTION, Def.CONSUMPTION_FIELDS[0]);

	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, (int) shopId);
	            rs = stmt.executeQuery();
	            List<Consumption> rlt = new ArrayList<Consumption>();
	            while (rs.next()) {
	            	Consumption one = UserDAOUtil.parseConsumption(rs);
	                rlt.add(one);
	                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
	            }
	            return rlt.toArray(new Consumption[0]);
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_CONSUMPTION);
	        } finally {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
	        assert false;
	        return null;
	}

	@Override
	public Consumption[] selectConsumptions() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_CONSUMPTION);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Consumption> rlt = new ArrayList<Consumption>();
            while (rs.next()) {
            	Consumption one = UserDAOUtil.parseConsumption(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Consumption[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_CONSUMPTION);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	


}

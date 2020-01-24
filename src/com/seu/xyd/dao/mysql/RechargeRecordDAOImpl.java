package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.RechargeRecordDAO;
import com.seu.xyd.data.RechargeRecord;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class RechargeRecordDAOImpl implements RechargeRecordDAO{

    @Override
    public long insertRechargeRecord(RechargeRecord rechargeRecord) throws DBProcessException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_RECHARGE_RECORD, Def.RECHARGE_RECORD_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(rechargeRecord, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
    }

    @Override
    public RechargeRecord selectRechargeRecord(long id) throws DBProcessException, NoSuchCase {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_RECHARGE_RECORD, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                RechargeRecord rechargeRecord = UserDAOUtil.parseRechargeRecord(rs);
                assert !rs.next();
                return rechargeRecord;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
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
	public void deleteRechargeRecord(long id) throws DBProcessException, NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String sql = "delete from %s where id=?";
	        sql = String.format(sql, Def.T_RECHARGE_RECORD);
	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setLong(1, id);
	            int rlt = stmt.executeUpdate();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
	        } finally {
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
		
	}

	@Override
	public void updateRechargeRecord(RechargeRecord rechargeRecord) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_RECHARGE_RECORD, Def.RECHARGE_RECORD_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(rechargeRecord, stmt);
            stmt.setLong(Def.RECHARGE_RECORD_FIELDS.length + 1, rechargeRecord.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public RechargeRecord[] selectRechargeRecordByUserId(long userId, int page) throws DBProcessException{
		 	Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        int pageSize = 10;
	        int start = pageSize*(page-1);
	        String sql = "select * from %s where %s=? group by id limit ?,?";
	        sql = String.format(sql, Def.T_RECHARGE_RECORD, Def.RECHARGE_RECORD_FIELDS[0]);

	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, (int) userId);
	            stmt.setInt(2, start);
	            stmt.setInt(3, pageSize);
	            rs = stmt.executeQuery();

	            List<RechargeRecord> rlt = new ArrayList<RechargeRecord>();
	            while (rs.next()) {
	            	RechargeRecord one = UserDAOUtil.parseRechargeRecord(rs);
	                rlt.add(one);
	            }
	            return rlt.toArray(new RechargeRecord[0]);
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
	        } finally {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
	        assert false;
	        return null;
	}

	@Override
	public RechargeRecord[] selectRechargeRecords() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_RECHARGE_RECORD);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<RechargeRecord> rlt = new ArrayList<RechargeRecord>();
            while (rs.next()) {
            	RechargeRecord one = UserDAOUtil.parseRechargeRecord(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new RechargeRecord[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public RechargeRecord getRechargeRecord(int id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_RECHARGE_RECORD, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	RechargeRecord one = UserDAOUtil.parseRechargeRecord(rs);
            	return one;
            }else{
            	throw new NoSuchCase();
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}



	@Override
	public int getRecordCountByUserId(long userId) throws DBProcessException {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        String sql = "select count(*) as sum from %s where %s=?";
	        sql = String.format(sql, Def.T_RECHARGE_RECORD, Def.RECHARGE_RECORD_FIELDS[0]);

	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, (int) userId);
	            rs = stmt.executeQuery();

	            List<RechargeRecord> rlt = new ArrayList<RechargeRecord>();
	            if (rs.next()) {
	            	int count = DBUtil.getInt(rs, "sum");
	            	return count;
	            }
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_RECHARGE_RECORD);
	        } finally {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
	        assert false;
	        return 0;
	}


}

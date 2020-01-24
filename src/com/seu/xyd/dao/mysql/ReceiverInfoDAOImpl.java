package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.ReceiverInfoDAO;
import com.seu.xyd.data.ReceiverInfo;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class ReceiverInfoDAOImpl implements ReceiverInfoDAO{

	@Override
	public void deleteAllDataONLYFORTEST() throws DBProcessException {

		
	}

	@Override
	public long insertReceiverInfo(ReceiverInfo receiverInfo) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_RECEIVER_INFO, Def.RECEIVER_INFO_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(receiverInfo, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECEIVER_INFO);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}

	@Override
	public ReceiverInfo selectReceiverInfo(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_RECEIVER_INFO, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	ReceiverInfo receiverInfo = UserDAOUtil.parseReceiverInfo(rs);
                assert !rs.next();
                return receiverInfo;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECEIVER_INFO);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	

	@Override
	public void deleteReceiverInfo(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "delete from %s where id=?";
        sql = String.format(sql, Def.T_RECEIVER_INFO);
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rlt = stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECEIVER_INFO);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
	}

	@Override
	public void updateReceiverInfo(ReceiverInfo ReceiverInfo) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_RECEIVER_INFO, Def.RECEIVER_INFO_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(ReceiverInfo, stmt);
            stmt.setLong(Def.RECEIVER_INFO_FIELDS.length + 1, ReceiverInfo.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECEIVER_INFO);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public ReceiverInfo[] selectReceiverInfos() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_RECEIVER_INFO);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<ReceiverInfo> rlt = new ArrayList<ReceiverInfo>();
            while (rs.next()) {
            	ReceiverInfo one = UserDAOUtil.parseReceiverInfo(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new ReceiverInfo[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECEIVER_INFO);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}
	@Override
	public ReceiverInfo[] selectReceiverInfosByUserId(long userId) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_RECEIVER_INFO,Def.F_USER_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, userId);
            rs = stmt.executeQuery();
            List<ReceiverInfo> rlt = new ArrayList<ReceiverInfo>();
            while (rs.next()) {
            	ReceiverInfo one = UserDAOUtil.parseReceiverInfo(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new ReceiverInfo[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_RECEIVER_INFO);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}



}

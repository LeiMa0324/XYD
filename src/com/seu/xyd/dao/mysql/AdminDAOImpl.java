package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.AdminDAO;
import com.seu.xyd.data.Admin;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class AdminDAOImpl implements AdminDAO{

    @Override
    public long insertAdmin(Admin admin) throws DBProcessException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_ADMIN, Def.ADMIN_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(admin, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ADMIN);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
    }

    @Override
    public Admin selectAdmin(long id) throws DBProcessException, NoSuchCase {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ADMIN, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Admin admin = UserDAOUtil.parseAdmin(rs);
                assert !rs.next();
                return admin;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ADMIN);
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
	public void deleteAdmin(long id) throws DBProcessException, NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String sql = "delete from %s where id=?";
	        sql = String.format(sql, Def.T_ADMIN);
	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setLong(1, id);
	            int rlt = stmt.executeUpdate();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_ADMIN);
	        } finally {
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
		
	}

	@Override
	public void updateAdmin(Admin admin) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_ADMIN, Def.ADMIN_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(admin, stmt);
            stmt.setLong(Def.ADMIN_FIELDS.length + 1, admin.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ADMIN);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public Admin selectAdminByAccount(String account) throws DBProcessException,
			NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        String sql = "select * from %s where %s=?";
	        sql = String.format(sql, Def.T_ADMIN, Def.ADMIN_FIELDS[1]);

	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, account);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                Admin admin = UserDAOUtil.parseAdmin(rs);
	                assert !rs.next();
	                return admin;
	            }
	            throw new NoSuchCase();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_ADMIN);
	        } finally {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
	        assert false;
	        return null;
	}

	@Override
	public Admin[] selectAdmins() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_ADMIN);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Admin> rlt = new ArrayList<Admin>();
            while (rs.next()) {
            	Admin one = UserDAOUtil.parseAdmin(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Admin[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ADMIN);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public Admin getAdmin(int id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_ADMIN, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	Admin one = UserDAOUtil.parseAdmin(rs);
            	return one;
            }else{
            	throw new NoSuchCase();
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_ADMIN);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}


}

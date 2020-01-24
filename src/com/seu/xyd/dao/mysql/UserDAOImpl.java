package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.UserDAO;
import com.seu.xyd.data.Goods;
import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class UserDAOImpl implements UserDAO{

    @Override
    public long insertUser(User user) throws DBProcessException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_USER, Def.USER_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(user, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_USER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
    }

    @Override
    public User selectUser(long id) throws DBProcessException, NoSuchCase {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_USER, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                User user = UserDAOUtil.parseUser(rs);
                assert !rs.next();
                return user;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_USER);
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
	public void deleteUser(long id) throws DBProcessException, NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String sql = "delete from %s where id=?";
	        sql = String.format(sql, Def.T_USER);
	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setLong(1, id);
	            int rlt = stmt.executeUpdate();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_USER);
	        } finally {
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
		
	}

	@Override
	public void updateUser(User user) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_USER, Def.USER_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(user, stmt);
            stmt.setLong(Def.USER_FIELDS.length + 1, user.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_USER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public User selectUserByAccount(String account) throws DBProcessException,
			NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        String sql = "select * from %s where %s=?";
	        sql = String.format(sql, Def.T_USER, Def.USER_FIELDS[0]);

	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, account);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                User user = UserDAOUtil.parseUser(rs);
	                assert !rs.next();
	                return user;
	            }
	            throw new NoSuchCase();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_USER);
	        } finally {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
	        assert false;
	        return null;
	}

	@Override
	public User[] selectUsers() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_USER);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<User> rlt = new ArrayList<User>();
            while (rs.next()) {
            	User one = UserDAOUtil.parseUser(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new User[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_USER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	@Override
	public User getUser(int id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_USER, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	User one = UserDAOUtil.parseUser(rs);
            	return one;
            }else{
            	throw new NoSuchCase();
            }
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_USER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}


	
	public User[] getUserListByShopIdWithPage(String keyWord, int page) throws DBProcessException
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pageSize = 8;
        int start = (page-1)*pageSize;

        String sql = "select * from %s where %s like ?  group by id limit ?,?";
        sql = String.format(sql, Def.T_USER,Def.USER_FIELDS[0]);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            String keywordString = new String("%"+keyWord+"%");
            stmt.setString(1, keywordString);
            stmt.setInt(2, start);
            stmt.setInt(3, pageSize);
            rs = stmt.executeQuery();
            List<User> rlt = new ArrayList<User>();
            while (rs.next()) {
            	User one = UserDAOUtil.parseUser(rs);
                rlt.add(one);
            }
            return rlt.toArray(new User[0]);
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
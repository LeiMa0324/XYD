package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.EmployerDAO;
import com.seu.xyd.data.Employer;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class EmployerDAOImpl implements EmployerDAO{

    @Override
    public long insertEmployer(Employer employer) throws DBProcessException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_EMPLOYER, Def.EMPLOYER_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(employer, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_EMPLOYER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
    }

    @Override
    public Employer selectEmployer(long id) throws DBProcessException, NoSuchCase {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_EMPLOYER, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Employer employer = UserDAOUtil.parseEmployer(rs);
                assert !rs.next();
                return employer;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_EMPLOYER);
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
	public void deleteEmployer(long id) throws DBProcessException, NoSuchCase {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String sql = "delete from %s where id=?";
	        sql = String.format(sql, Def.T_EMPLOYER);
	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setLong(1, id);
	            int rlt = stmt.executeUpdate();
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_EMPLOYER);
	        } finally {
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
		
	}

	@Override
	public void updateEmployer(Employer employer) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_EMPLOYER, Def.EMPLOYER_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(employer, stmt);
            stmt.setLong(Def.EMPLOYER_FIELDS.length + 1, employer.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_EMPLOYER);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public Employer[] selectEmployersByShopId(long shopId) throws DBProcessException{
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        String sql = "select * from %s where %s=?";
	        sql = String.format(sql, Def.T_EMPLOYER, Def.EMPLOYER_FIELDS[0]);

	        try {
	            conn = ConnUtil.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, (int) shopId);
	            rs = stmt.executeQuery();
	            List<Employer> rlt = new ArrayList<Employer>();
	            while (rs.next()) {
	            	Employer one = UserDAOUtil.parseEmployer(rs);
	                rlt.add(one);
	                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
	            }
	            return rlt.toArray(new Employer[0]);
	        } catch (SQLException e) {
	            DBUtil.processSQLException(e, Def.T_EMPLOYER);
	        } finally {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closeStatement(stmt);
	            ConnUtil.closeConnection(conn);
	        }
	        assert false;
	        return null;
	}

	@Override
	public Employer[] selectEmployers() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_EMPLOYER);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Employer> rlt = new ArrayList<Employer>();
            while (rs.next()) {
            	Employer one = UserDAOUtil.parseEmployer(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new Employer[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_EMPLOYER);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	


}

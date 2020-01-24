package com.seu.xyd.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seu.xyd.dao.GoodsImgDAO;
import com.seu.xyd.data.GoodsImg;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.DBUtil;
import com.tn17.mysql.NoSuchCase;

public class GoodsImgDAOImpl implements GoodsImgDAO{

	@Override
	public void deleteAllDataONLYFORTEST() throws DBProcessException {

		
	}

	@Override
	public long insertGoodsImg(GoodsImg goodsImg) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getInsertSQL(Def.T_GOODS_IMG, Def.GOODS_IMG_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            UserDAOUtil.setFields(goodsImg, stmt);

            return DBUtil.executeInsert(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS_IMG);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return 0;
	}

	@Override
	public GoodsImg selectGoodsImg(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_GOODS_IMG, Def.F_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	GoodsImg goodsImg = UserDAOUtil.parseGoodsImg(rs);
                assert !rs.next();
                return goodsImg;
            }
            throw new NoSuchCase();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS_IMG);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}

	

	@Override
	public void deleteGoodsImg(long id) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "delete from %s where id=?";
        sql = String.format(sql, Def.T_GOODS_IMG);
        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rlt = stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS_IMG);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
	}

	@Override
	public void updateGoodsImg(GoodsImg GoodsImg) throws DBProcessException, NoSuchCase {
		Connection conn = null;
        PreparedStatement stmt = null;

        String sql = DBUtil.getUpdateSQL(Def.T_GOODS_IMG, Def.GOODS_IMG_FIELDS);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            UserDAOUtil.setFields(GoodsImg, stmt);
            stmt.setLong(Def.GOODS_IMG_FIELDS.length + 1, GoodsImg.getId());
            DBUtil.executeUpdateSingleCase(stmt);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS_IMG);
        } finally {
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
		
	}

	@Override
	public GoodsImg[] selectGoodsImgs() throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s";
        sql = String.format(sql, Def.T_GOODS_IMG);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<GoodsImg> rlt = new ArrayList<GoodsImg>();
            while (rs.next()) {
            	GoodsImg one = UserDAOUtil.parseGoodsImg(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new GoodsImg[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS_IMG);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}
	@Override
	public GoodsImg[] selectGoodsImgsByGoodsId(long goodsImgId) throws DBProcessException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from %s where %s=?";
        sql = String.format(sql, Def.T_GOODS_IMG,Def.F_GOODS_ID);

        try {
            conn = ConnUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, goodsImgId);
            rs = stmt.executeQuery();
            List<GoodsImg> rlt = new ArrayList<GoodsImg>();
            while (rs.next()) {
            	GoodsImg one = UserDAOUtil.parseGoodsImg(rs);
                rlt.add(one);
                //System.out.println(rs.getString(1)+"_"+rs.getInt(2));
            }
            return rlt.toArray(new GoodsImg[0]);
        } catch (SQLException e) {
            DBUtil.processSQLException(e, Def.T_GOODS_IMG);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            ConnUtil.closeConnection(conn);
        }
        assert false;
        return null;
	}



}

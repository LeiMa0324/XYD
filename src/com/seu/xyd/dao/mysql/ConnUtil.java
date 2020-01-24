package com.seu.xyd.dao.mysql;

import java.sql.Connection;

import com.tn17.mysql.ConnectionsPoolFactory;
import com.tn17.mysql.DBProcessException;
import com.tn17.mysql.IllegalDBStateException;

public class ConnUtil {
    private static ConnectionsPoolFactory FACTORY = ConnectionsPoolFactory.getInstance();

    private final static String DBNAME = "xyd_db";

    public static Connection getConnection() throws DBProcessException, IllegalDBStateException {
        Connection conn = null;
        conn = FACTORY.getPool(DBNAME).getConnection();
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn == null) {
            return;
        }
        assert conn != null : "give null to closeConnection.";
        FACTORY.getPool(DBNAME).closeConnection(conn);
    }
}

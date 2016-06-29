/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import Support.Global;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TRUNGHIEU
 */
public class SQLServerConnUtils_SQLJDBC {

    // Kết nối vào SQLServer.
    // (Sử dụng thư viện điều khiển SQLJDBC)
    public static Connection getSQLServerConnection()
            throws SQLException, ClassNotFoundException {
        if (Global.DatabaseProperty.getHostName().isEmpty()) {
            return null;
        }
        String hostName = Global.DatabaseProperty.getHostName();
        String sqlInstanceName = Global.DatabaseProperty.getSqlInstanceName();
        String database = Global.DatabaseProperty.getDatabase();
        String userName = Global.DatabaseProperty.getUserName();
        String password = Global.DatabaseProperty.getPassword();

        return getSQLServerConnection(hostName, sqlInstanceName,
                database, userName, password);
    }

    // Trường hợp sử dụng SQLServer.
    // Và thư viện SQLJDBC.
    public static Connection getSQLServerConnection(String hostName,
            String sqlInstanceName, String database, String userName,
            String password) throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
                + ";instance=" + sqlInstanceName + ";databaseName=" + database;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}

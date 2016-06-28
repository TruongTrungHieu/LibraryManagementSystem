/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ELC-17
 */
public class DatabaseWorker {

    public static Connection conn = null;// store a connection object to connect to database
    public static ResultSet rs = null;// return a result set when a sqlquery statment is executed
    public static Statement stm = null;// create a statment to prepar to insert,select ... 
    public static ResultSetMetaData stmt;//return infomations about result set 
    public static Vector cols;//return number of record column 
    public static Vector rows;//return records info
    public static Vector datas;

    /**
     * this method will return a connection accoding to 1 standard
     *
     * @return
     */
    public static Connection getConnection1() {

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:" + DatabaseProperty.Datasourcename;
            System.out.println("" + url);
            System.out.println("" + DatabaseProperty.Username);
            System.out.println("" + DatabaseProperty.Password);
            return DriverManager.getConnection(url, DatabaseProperty.Username, DatabaseProperty.Password);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * this method will return a connection accoding to 4 standard
     *
     * @return
     */
    public static Connection getConnection4() {
        try {
            String url;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = "jdbc:sqlserver";
            url = url + "://" + DatabaseProperty.Servername + ":" + DatabaseProperty.Port + ";databasename=" + DatabaseProperty.DatabaseName;

            System.out.println("" + url);
            System.out.println("" + DatabaseProperty.Username);
            System.out.println("" + DatabaseProperty.Password);
            return DriverManager.getConnection(url, DatabaseProperty.Username, DatabaseProperty.Password);
        } catch (ClassNotFoundException | SQLException e) {
            // e.printStackTrace();
            return null;
        }

    }

    /**
     *
     * this method will return a connection to database
     *
     * @return
     */
    public static Connection getConnection() {
        int type = DatabaseProperty.Type;
        System.out.println("" + type);
        if (type == 1) {

            return getConnection1();

        }
        if (type == 4) {
            return getConnection4();
        }
        return null;
    }

    /**
     *
     * this method will be called when user not connect to the database
     *
     * @param obj
     */
    public static void disconnect(Object obj) {
        if (obj == null) {
            return;
        } else {
            try {

                if (obj instanceof Statement) {
                    ((Statement) obj).close();
                    return;
                }
                if (obj instanceof ResultSet) {
                    ((ResultSet) obj).close();
                    return;
                }
                if (obj instanceof ResultSet) {
                    ((ResultSet) obj).close();
                    return;
                }
                if (obj instanceof Connection) {
                    ((Connection) obj).close();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     *
     * this method will be called when a sql statement is execute : insert ,
     * delete ,update
     *
     * @param sql
     * @return
     */
    public static boolean execute(String sql) {
        try {
            conn = getConnection();
            stm = conn.createStatement();
            stm.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            disconnect(stm);
            disconnect(conn);
        }

    }

    /**
     *
     * this method will be called when a select statement is execute and if
     * success it will return result set as Vectors
     *
     * @param sql
     * @return
     */
    public static boolean executequery(String sql) {
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            loadData();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            disconnect(stm);
            disconnect(conn);

        }

    }

    /**
     *
     * this method will be called when a user log in the system to check
     * validation
     */
    public static void checkconnect() {
        //  login=lg;  
        if (getConnection() == null) {

            System.out.println("not success !");
            ConnectDatabase gg = new ConnectDatabase(null, true);
            gg.setVisible(true);
        } else {
            System.out.println("successful!");
        }
    }

    private static void loadData() {
        try {
            stmt = rs.getMetaData();
            int numberofcolumns = stmt.getColumnCount();
            cols = new Vector();
            for (int i = 1; i <= numberofcolumns; i++) {
                cols.add(stmt.getColumnName(i));
            }
            datas = new Vector();
            while (rs.next()) {
                rows = new Vector();

                for (int i = 1; i <= numberofcolumns; i++) {
                    rows.add(rs.getString(i));
                }
                datas.add(rows);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

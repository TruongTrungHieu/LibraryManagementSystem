/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

/**
 *
 * @author ELC-17
 */
public class DatabaseProperty {

    private String hostName;
    private String sqlInstanceName;
    private String database;
    private String userName;
    private String password;

    public DatabaseProperty() {
        this.hostName = "localhost";
        this.sqlInstanceName = "ELC17\\SQLEXPRESS";
        this.database = "QLTV";
        this.userName = "sa";
        this.password = "123456";
    }

    public DatabaseProperty(String hostName, String sqlInstanceName, String database, String userName, String password) {
        this.hostName = hostName;
        this.sqlInstanceName = sqlInstanceName;
        this.database = database;
        this.userName = userName;
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getSqlInstanceName() {
        return sqlInstanceName;
    }

    public void setSqlInstanceName(String sqlInstanceName) {
        this.sqlInstanceName = sqlInstanceName;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

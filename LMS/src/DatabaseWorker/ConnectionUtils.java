/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author TRUNGHIEU
 */
public class ConnectionUtils {

    public static Connection getMyConnection() throws SQLException,
            ClassNotFoundException {
        return SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
    }
}

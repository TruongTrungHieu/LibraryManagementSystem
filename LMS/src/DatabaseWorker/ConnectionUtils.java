/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class ConnectionUtils {

    public static Connection getMyConnection() {
        try {
            return SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

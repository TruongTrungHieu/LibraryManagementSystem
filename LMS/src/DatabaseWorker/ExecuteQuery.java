/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TRUNGHIEU
 */
public class ExecuteQuery {

    private Connection _connection;
    private Statement _statement;
    private static ExecuteQuery instance = null;

    public ExecuteQuery() throws SQLException, ClassNotFoundException {
        _connection = ConnectionUtils.getMyConnection();
        _statement = _connection.createStatement();
    }

    public static ExecuteQuery getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new ExecuteQuery();
        }
        return instance;
    }

}

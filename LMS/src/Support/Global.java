/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import DatabaseWorker.DatabaseProperty;
import Objects.Employees;
import Objects.Readers;

/**
 *
 * @author ELC-17
 */
public class Global {

    /**
     *  Database information
     */
    public static DatabaseWorker.DatabaseProperty DatabaseProperty = new DatabaseProperty();
    
    /**
     *  Employee
     */
    public static Employees Employee;
    
    /**
     * Reader
     */
    public static Readers Reader;
    /**
     *  Account type
     */
    public static boolean isEmployee = true;
    /**
     *  Đang mượn
     */
    public static final int ISSUE_STATUS_BORROWING = 1;
    /**
     *  Đã trả
     */
    public static final int ISSUE_STATUS_DONE = 2;
    
    /**
     * Permission Admin
     */
    public static final String PERMISSION_ADMIN = "1";

    /**
     *  Permission Employee
     */
    public static final String PERMISSION_EMPLOYEE = "2";
}

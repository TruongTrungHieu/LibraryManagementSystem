/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import Objects.Books;
import Objects.Categories;
import Objects.Employees;
import Objects.Fine;
import Objects.Issue;
import Objects.Permission;
import Objects.Publishers;
import Objects.Readers;
import Support.DatetimeUtils;
import Support.Global;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author TRUNGHIEU
 */
public class ExecuteQuery {

    private static Connection _connection;
    private static Statement _statement;
    private static ExecuteQuery instance = null;

    public ExecuteQuery() throws SQLException, ClassNotFoundException {
        _connection = ConnectionUtils.getMyConnection();
        _statement = _connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static ExecuteQuery getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new ExecuteQuery();
        }
        return instance;
    }

    /**
     * Books
     */
    /**
     * Select all from Books
     *
     * @return
     */
    public ArrayList<Books> getAllBooks() {
        ArrayList<Books> listBook = new ArrayList<>();
        String sel_all_book = "SELECT BookID, Title, AuthorName, Books.CategoryID, Categories.CateName, Books.PublisherID, Publishers.PubName, Numberofcopies, Description FROM Books";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_book);
            if (rs.first()) {
                do {
                    Books book = new Books();

                    book.setBookID(rs.getString(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthorName(rs.getString(3));

                    Categories categories = new Categories();
                    categories.setCateID(rs.getString(4));
                    categories.setCateName(rs.getString(5));
                    book.setCategory(categories);

                    Publishers publisher = new Publishers();
                    publisher.setPubID(rs.getString(6));
                    publisher.setPubName(rs.getString(7));
                    book.setPublisher(publisher);

                    book.setNumberOfCopy(rs.getInt(8));
                    book.setDescription(rs.getString(9));

                    listBook.add(book);
                } while (rs.next());
            }
            return listBook;
        } catch (Exception e) {
            System.out.println("getAllBooks:" + e.getMessage());
            return null;
        }
    }

    /**
     * Categories
     */
    /**
     * Select all from Categories
     *
     * @return
     */
    public ArrayList<Categories> getAllCategories() {
        ArrayList<Categories> listCategory = new ArrayList<>();
        String sel_all_category = "SELECT CateID, CateName FROM Categories";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_category);
            if (rs.first()) {
                do {
                    Categories category = new Categories();

                    category.setCateID(rs.getString(1));
                    category.setCateName(rs.getString(2));

                    listCategory.add(category);
                } while (rs.next());
            }
            return listCategory;
        } catch (Exception e) {
            System.out.println("getAllCategories:" + e.getMessage());
            return null;
        }
    }

    /**
     * Employees
     */
    /**
     * Employee login
     *
     * @param username
     * @param pass
     * @return
     */
    public boolean loginEmployee(String username, String pass) {
        String login_sql = "SELECT EmployeeID, Emp_name, Address, Phonenumber, Email, Employees.PerID, Permission.Pername, Username "
                + "FROM Employees INNER JOIN Permission ON Employees.PerID = Permission.PerID "
                + "WHERE Username = '" + username + "' AND [Password] = '" + pass + "'";
        try {
            ResultSet rs = _statement.executeQuery(login_sql);
            if (!rs.first()) {
                return false;
            }
            Global.Employee = new Employees();
            Global.Employee.setEmployeeID(rs.getString(1));
            Global.Employee.setEmployeeName(rs.getString(2));
            Global.Employee.setAddress(rs.getString(3));
            Global.Employee.setPhoneNumber(rs.getString(4));
            Global.Employee.setEmail(rs.getString(5));

            Permission permission = new Permission();
            permission.setPermissionID(rs.getString(6));
            permission.setPermissionName(rs.getString(7));
            Global.Employee.setPermission(permission);
            Global.Employee.setUsername(rs.getString(8));

            Global.isEmployee = true;

            return true;
        } catch (Exception e) {
            System.out.println("loginEmployee:" + e.getMessage());
            return false;
        }
    }

    /**
     * Fine
     */
    /**
     * Select all from fine
     *
     * @return
     */
    public ArrayList<Fine> getAllFine() {
        ArrayList<Fine> listFine = new ArrayList<>();
        String sel_all_fine = "SELECT FineID, FineName, Description, Cost FROM Fine";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_fine);
            if (rs.first()) {
                do {
                    Fine fine = new Fine();

                    fine.setFineID(rs.getString(1));
                    fine.setFineName(rs.getString(2));
                    fine.setDescription(rs.getString(3));
                    fine.setCost(rs.getDouble(4));

                    listFine.add(fine);
                } while (rs.next());
            }
            return listFine;
        } catch (Exception e) {
            System.out.println("getAllFine:" + e.getMessage());
            return null;
        }
    }

    /**
     * Issue
     */
    /**
     * Select all from Issue
     *
     * @return
     */
    public ArrayList<Issue> getAllIssue() {
        ArrayList<Issue> listIssue = new ArrayList<>();
        String sel_all_issue = "SELECT Issue.IssueID, Issue.ReaderID, Reader.ReaderName, Reader.PhoneNumber, Issue.EmployeeID, Employees.Emp_name, Employees.Address, Employees.PhoneNumber, Employees.Email, Employees.PerID, Issue.IssueDate, Issue.DueDate, Issue.ReturnDate, Issue.TotalFine, Issue.Status "
                             + "FROM Issue INNER JOIN Employees ON Issue.EmployeesID = Employees.EmployeeID "
                             + "INNER JOIN Reader ON Issue.Employees.ReaderID = Reader.ReaderID";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_issue);
            if (rs.first()) {
                do {
                    Issue issue = new Issue();

                    issue.setIssueID(rs.getString(1));
                    
                    Readers reader = new Readers();
                    reader.setReaderID(rs.getString(2));
                    reader.setReaderName(rs.getString(3));
                    reader.setPhoneNumber(rs.getString(4));
                    issue.setReader(reader);
                    
                    Employees employees = new Employees();
                    employees.setEmployeeID(rs.getString(5));
                    employees.setEmployeeName(rs.getString(6));
                    employees.setAddress(rs.getString(7));
                    employees.setPhoneNumber(rs.getString(8));
                    employees.setEmail(rs.getString(9));
                    Permission permission = new Permission();
                    permission.setPermissionID(rs.getString(10));
                    employees.setPermission(permission);
                    issue.setEmployee(employees);
                    
                    issue.setIssueDate(DatetimeUtils.convertStringToDate(rs.getString(11)));
                    issue.setDueDate(DatetimeUtils.convertStringToDate(rs.getString(12)));
                    issue.setReturnDate(DatetimeUtils.convertStringToDate(rs.getString(13)));
                    issue.setTotalFine(rs.getDouble(14));
                    issue.setStatus(rs.getInt(15));
                    
                    listIssue.add(issue);
                } while (rs.next());
            }
            return listIssue;
        } catch (Exception e) {
            System.out.println("getAllIssue:" + e.getMessage());
            return null;
        }
    }

    /**
     * Issue Detail
     */
    /**
     * Permission
     */
    /**
     * Select all from Permission
     *
     * @return
     */
    public ArrayList<Permission> getAllPermission() {
        ArrayList<Permission> listPermission = new ArrayList<>();
        String sel_all_permission = "SELECT PerID, Pername FROM Permission";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_permission);
            if (rs.first()) {
                do {
                    Permission permission = new Permission();

                    permission.setPermissionID(rs.getString(1));
                    permission.setPermissionName(rs.getString(2));

                    listPermission.add(permission);
                } while (rs.next());
            }
            return listPermission;
        } catch (Exception e) {
            System.out.println("getAllPermission:" + e.getMessage());
            return null;
        }
    }

    /**
     * Publishers
     */
    /**
     * Select all from Publishers
     *
     * @return
     */
    public ArrayList<Publishers> getAllPublisher() {
        ArrayList<Publishers> listPublisher = new ArrayList<>();
        String sel_all_publishers = "SELECT PubID, PubName FROM Publishers";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_publishers);
            if (rs.first()) {
                do {
                    Publishers publisher = new Publishers();

                    publisher.setPubID(rs.getString(1));
                    publisher.setPubName(rs.getString(2));

                    listPublisher.add(publisher);
                } while (rs.next());
            }
            return listPublisher;
        } catch (Exception e) {
            System.out.println("getAllPublisher:" + e.getMessage());
            return null;
        }
    }

    /**
     * Readers
     */
    /**
     * Reader login
     *
     * @param username
     * @param pass
     * @return
     */
    public boolean loginReader(String username, String pass) {
        String login_sql = "SELECT ReaderID, ReaderName, PhoneNumber, UserName FROM Reader WHERE UserName = '" + username + "' AND [Password] = '" + pass + "'";
        try {
            _statement = _connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = _statement.executeQuery(login_sql);
            if (!rs.first()) {
                return false;
            }
            Global.Reader = new Readers();
            Global.Reader.setReaderID(rs.getString(1));
            Global.Reader.setReaderName(rs.getString(2));
            Global.Reader.setPhoneNumber(rs.getString(3));
            Global.Reader.setUserName(rs.getString(4));

            Global.isEmployee = false;

            return true;
        } catch (Exception e) {
            System.out.println("loginEmployee:" + e.getMessage());
            return false;
        }
    }

    /**
     * Select all from Readers
     *
     * @return
     */
    public ArrayList<Readers> getAllReaders() {
        ArrayList<Readers> listReader = new ArrayList<>();
        String sel_all_reader = "SELECT ReaderID, ReaderName, PhoneNumber, UserName FROM Reader";
        try {
            ResultSet rs = _statement.executeQuery(sel_all_reader);
            if (rs.first()) {
                do {
                    Readers readers = new Readers();

                    readers.setReaderID(rs.getString(1));
                    readers.setReaderName(rs.getString(2));
                    readers.setPhoneNumber(rs.getString(3));
                    readers.setUserName(rs.getString(4));

                    listReader.add(readers);
                } while (rs.next());
            }
            return listReader;
        } catch (Exception e) {
            System.out.println("getAllReaders:" + e.getMessage());
            return null;
        }
    }

    /**
     * Insert reader
     *
     * @param reader
     * @return
     */
    public boolean insertReader(Readers reader) {
        String ins_reader = "INSERT INTO Reader VALUES ('" + reader.getReaderID() + "', '" + reader.getReaderName() + "', '" + reader.getPhoneNumber() + "', '" + reader.getUserName() + "', '" + reader.getUserName() + "')";
        try {
            int row_affected = _statement.executeUpdate(ins_reader);
            return row_affected != 0;
        } catch (Exception e) {
            System.out.println("insertReader:" + e.getMessage());
            return false;
        }
    }
}

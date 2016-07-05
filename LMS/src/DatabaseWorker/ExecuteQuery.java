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
import Objects.IssueDetail;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class ExecuteQuery {

    private static Connection _connection;
    private static Statement _statement;
    private static ExecuteQuery instance = null;

    public ExecuteQuery() throws SQLException, ClassNotFoundException {
        _connection = ConnectionUtils.getMyConnection();
        _statement = _connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static ExecuteQuery getInstance() {
        if (instance == null) {
            try {
                instance = new ExecuteQuery();
            } catch (SQLException ex) {
                Logger.getLogger(ExecuteQuery.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ExecuteQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        String sel_all_book = "SELECT BookID, Title, AuthorName, Books.CategoryID, Categories.CateName, Books.PublisherID, Publishers.PubName, Numberofcopies, [Description] "
                + "FROM Books INNER JOIN Categories ON Books.CategoryID = Categories.CateID "
                + "INNER JOIN Publishers ON Books.PublisherID = Publishers.PubID "
                + "ORDER BY Title";
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
     * Insert single book
     *
     * @param book
     * @return
     */
    public boolean insertBook(Books book) {
        String ins_book = "INSERT INTO Books VALUES ('" + book.getBookID() + "', N'" + book.getTitle() + "', N'" + book.getAuthorName() + "', '" + book.getCategory().getCateID() + "', '" + book.getPublisher().getPubID() + "', " + book.getNumberOfCopy() + ", N'" + book.getDescription() + "')";
        try {
            int row_affected = _statement.executeUpdate(ins_book);
            return row_affected != 0;
        } catch (Exception e) {
            System.out.println("insertBook:" + e.getMessage());
            return false;
        }
    }

    /**
     * Update single book
     *
     * @param book
     * @return
     */
    public boolean updateBook(Books book) {
        String upd_book = "UPDATE Books SET Title = N'" + book.getTitle() + "', AuthorName = N'" + book.getAuthorName() + "', CategoryID = '" + book.getCategory().getCateID() + "', PublisherID = '" + book.getPublisher().getPubID() + "', Numberofcopies = " + book.getNumberOfCopy() + ", Description = N'" + book.getDescription() + "' WHERE BookID = '" + book.getBookID() + "'";
        try {
            int row_affected = _statement.executeUpdate(upd_book);
            return row_affected != 0;
        } catch (Exception e) {
            System.out.println("updateBook:" + e.getMessage());
            return false;
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
    public boolean insertCate(Categories cate) {
        String ins_reader = "INSERT INTO Categories VALUES ('" + cate.getCateID() + "', N'" + cate.getCateName() + "')";
        try {
            int row_affected = _statement.executeUpdate(ins_reader);
            return row_affected != 0;
        } catch (Exception e) {
            System.out.println("insertCate:" + e.getMessage());
            return false;
        }
    }

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

    public boolean insertEmployee(Employees emp) {
        String ins_emp = "INSERT INTO Employees VALUES ('" + emp.getEmployeeID() + "', N'" + emp.getEmployeeName() + "', '" + emp.getAddress() + "', '" + emp.getPhoneNumber() + "', '" + emp.getEmail() + "', '" + emp.getPermission().getPermissionID() + "', '" + emp.getUsername() + "', '123456')";
        try {
            int row_affected = _statement.executeUpdate(ins_emp);
            return row_affected != 0;
        } catch (Exception e) {
            System.out.println("insertBook:" + e.getMessage());
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
                + "FROM Issue INNER JOIN Employees ON Issue.EmployeeID = Employees.EmployeeID "
                + "INNER JOIN Reader ON Issue.ReaderID = Reader.ReaderID";
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
     * Select all from Issue by Status
     *
     * @return
     */
    public ArrayList<Issue> getAllIssue(int status) {
        ArrayList<Issue> listIssue = new ArrayList<>();
        String sel_all_issue = "SELECT Issue.IssueID, Issue.ReaderID, Reader.ReaderName, Reader.PhoneNumber, Issue.EmployeeID, Employees.Emp_name, Employees.Address, Employees.PhoneNumber, Employees.Email, Employees.PerID, Issue.IssueDate, Issue.DueDate, Issue.ReturnDate, Issue.TotalFine, Issue.Status "
                + "FROM Issue INNER JOIN Employees ON Issue.EmployeeID = Employees.EmployeeID "
                + "INNER JOIN Reader ON Issue.ReaderID = Reader.ReaderID "
                + "WHERE Issue.Status = " + status;
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
            System.out.println("getAllIssue_status:" + e.getMessage());
            return null;
        }
    }

    /**
     * Issue Detail
     * @param issueID
     * @return 
     */
    public ArrayList<IssueDetail> getAllIssueDetail(String issueID) {
        ArrayList<IssueDetail> list = new ArrayList<>();
        String sel_issue_detail = "SELECT IssueID, Issue_detail.BookID, Books.Title, Issue_detail.FineID, Fine.FineName, Fine.Cost, Number "
                + "FROM Issue_detail INNER JOIN Books ON Issue_detail.BookID = Books.BookID "
                + "INNER JOIN Fine ON Issue_detail.FineID = Fine.FineID "
                + "WHERE IssueID = '" + issueID + "'";
        try {
            ResultSet rs = _statement.executeQuery(sel_issue_detail);
            if (rs.first()) {
                do {
                    IssueDetail id = new IssueDetail();

                    Issue issue = new Issue();
                    issue.setIssueID(rs.getString(1));
                    id.setIssue(issue);

                    Books b = new Books();
                    b.setBookID(rs.getString(2));
                    b.setTitle(rs.getString(3));
                    id.setBook(b);

                    Fine f = new Fine();
                    f.setFineID(rs.getString(4));
                    f.setFineName(rs.getString(5));
                    f.setCost(rs.getDouble(6));
                    id.setFine(f);

                    id.setNumber(rs.getInt(7));

                    list.add(id);
                } while (rs.next());
            }
            return list;
        } catch (Exception e) {
            System.out.println("getAllIssue_status:" + e.getMessage());
            return null;
        }
    }

    /**
     * @param issue
     * @param listDetail
     * @return
     */
    public boolean insertIssueAndDetail(Issue issue, ArrayList<IssueDetail> listDetail) {
        String ins_issue = "INSERT INTO Issue VALUES ('" + issue.getIssueID() + "', '" + issue.getReader().getReaderID() + "', '" + issue.getEmployee().getEmployeeID() + "', '" + DatetimeUtils.convertDateToString(issue.getIssueDate(), DatetimeUtils.DATE_FORMAT_SQL) + "', '" + DatetimeUtils.convertDateToString(issue.getDueDate(), DatetimeUtils.DATE_FORMAT_SQL) + "', '', " + issue.getTotalFine() + ", " + issue.getStatus() + ")";
        try {
            int row_affected = _statement.executeUpdate(ins_issue);
            if (row_affected != 0) {
                for (IssueDetail issueDetail : listDetail) {
                    String ins_detail = "INSERT INTO Issue_detail VALUES ('" + issue.getIssueID() + "', '" + issueDetail.getBook().getBookID() + "', '1', " + issueDetail.getNumber() + ")";
                    int row_detail_affected = _statement.executeUpdate(ins_detail);
                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("insertIssueAndDetail:" + e.getMessage());
            return false;
        }
        return true;
    }

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
    public boolean insertPub(Publishers pub) {
        String ins_pub = "INSERT INTO Publishers VALUES ('" + pub.getPubID() + "', N'" + pub.getPubName() + "')";
        try {
            int row_affected = _statement.executeUpdate(ins_pub);
            return row_affected != 0;
        } catch (Exception e) {
            System.out.println("insertPub:" + e.getMessage());
            return false;
        }
    }

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

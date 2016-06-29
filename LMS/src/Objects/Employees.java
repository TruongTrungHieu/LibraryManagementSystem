/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author ELC-17
 */
public class Employees {

    private String EmployeeID;
    private String EmployeeName;
    private String Address;
    private String PhoneNumber;
    private String Email;
    private Permission Permission;
    private String Username;

    public Employees() {

    }

    public Employees(String EmployeeID, String EmployeeName, String Address, String PhoneNumber, String Email, Permission Permission, String Username) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Permission = Permission;
        this.Username = Username;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Permission getPermission() {
        return Permission;
    }

    public void setPermission(Permission Permission) {
        this.Permission = Permission;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
}

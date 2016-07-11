/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;

/**
 *
 * @author 
 */
public class Issue {
    private String IssueID;
    private Readers Reader;
    private Employees Employee;
    private Date IssueDate;
    private Date DueDate;
    private Date ReturnDate;
    private double TotalFine;
    private int Status;
    
    public Issue(){
        
    }

    public Issue(String IssueID, Readers Reader, Employees Employee, Date IssueDate, Date DueDate, Date ReturnDate, double TotalFine, int Status) {
        this.IssueID = IssueID;
        this.Reader = Reader;
        this.Employee = Employee;
        this.IssueDate = IssueDate;
        this.DueDate = DueDate;
        this.ReturnDate = ReturnDate;
        this.TotalFine = TotalFine;
        this.Status = Status;
    }

    public String getIssueID() {
        return IssueID;
    }

    public void setIssueID(String IssueID) {
        this.IssueID = IssueID;
    }

    public Readers getReader() {
        return Reader;
    }

    public void setReader(Readers Reader) {
        this.Reader = Reader;
    }

    public Employees getEmployee() {
        return Employee;
    }

    public void setEmployee(Employees Employee) {
        this.Employee = Employee;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date IssueDate) {
        this.IssueDate = IssueDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public double getTotalFine() {
        return TotalFine;
    }

    public void setTotalFine(double TotalFine) {
        this.TotalFine = TotalFine;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
}

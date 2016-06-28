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
public class IssueDetail {

    private Issue Issue;
    private Books Book;
    private Fine fine;
    private int Number;

    public IssueDetail() {
    }

    public IssueDetail(Issue Issue, Books Book, Fine fine, int Number) {
        this.Issue = Issue;
        this.Book = Book;
        this.fine = fine;
        this.Number = Number;
    }

    public Issue getIssue() {
        return Issue;
    }

    public void setIssue(Issue Issue) {
        this.Issue = Issue;
    }

    public Books getBook() {
        return Book;
    }

    public void setBook(Books Book) {
        this.Book = Book;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

}

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
public class Books {

    private String BookID;
    private String Title;
    private String AuthorName;
    private Categories Category;
    private Publishers Publisher;
    private int NumberOfCopy;
    private String Description;

    public Books() {

    }

    public Books(String BookID, String Title, String AuthorName, Categories Category, Publishers Publisher, int NumberOfCopy, String Description) {
        this.BookID = BookID;
        this.Title = Title;
        this.AuthorName = AuthorName;
        this.Category = Category;
        this.Publisher = Publisher;
        this.NumberOfCopy = NumberOfCopy;
        this.Description = Description;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public Categories getCategory() {
        return Category;
    }

    public void setCategory(Categories Category) {
        this.Category = Category;
    }

    public Publishers getPublisher() {
        return Publisher;
    }

    public void setPublisher(Publishers Publisher) {
        this.Publisher = Publisher;
    }

    public int getNumberOfCopy() {
        return NumberOfCopy;
    }

    public void setNumberOfCopy(int NumberOfCopy) {
        this.NumberOfCopy = NumberOfCopy;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}

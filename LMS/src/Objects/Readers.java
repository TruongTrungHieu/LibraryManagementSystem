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
public class Readers {

    private String ReaderID;
    private String ReaderName;
    private String PhoneNumber;
    private String UserName;

    public Readers() {

    }

    public Readers(String ReaderID, String ReaderName, String PhoneNumber, String UserName) {
        this.ReaderID = ReaderID;
        this.ReaderName = ReaderName;
        this.PhoneNumber = PhoneNumber;
        this.UserName = UserName;
    }

    public String getReaderID() {
        return ReaderID;
    }

    public void setReaderID(String ReaderID) {
        this.ReaderID = ReaderID;
    }

    public String getReaderName() {
        return ReaderName;
    }

    public void setReaderName(String ReaderName) {
        this.ReaderName = ReaderName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}

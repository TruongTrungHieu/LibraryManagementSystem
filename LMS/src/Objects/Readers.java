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

    private int ReaderID;
    private String ReaderName;
    private String PhoneNumber;
    private String UserName;
    private String Password;

    public Readers() {

    }

    public Readers(int ReaderID, String ReaderName, String PhoneNumber, String UserName, String Password) {
        this.ReaderID = ReaderID;
        this.ReaderName = ReaderName;
        this.PhoneNumber = PhoneNumber;
        this.UserName = UserName;
        this.Password = Password;
    }

    public int getReaderID() {
        return ReaderID;
    }

    public void setReaderID(int ReaderID) {
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}

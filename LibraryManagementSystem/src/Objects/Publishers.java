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
public class Publishers {

    private int PubID;
    private String PubName;

    public Publishers() {

    }

    public Publishers(int PubID, String PubName) {
        this.PubID = PubID;
        this.PubName = PubName;
    }

    public int getPubID() {
        return PubID;
    }

    public void setPubID(int PubID) {
        this.PubID = PubID;
    }

    public String getPubName() {
        return PubName;
    }

    public void setPubName(String PubName) {
        this.PubName = PubName;
    }

}

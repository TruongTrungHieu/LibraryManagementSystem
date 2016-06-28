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
public class Fine {

    private int FineID;
    private String FineName;
    private double Cost;

    public Fine() {

    }

    public Fine(int FineID, String FineName, double Cost) {
        this.FineID = FineID;
        this.FineName = FineName;
        this.Cost = Cost;
    }

    public int getFineID() {
        return FineID;
    }

    public void setFineID(int FineID) {
        this.FineID = FineID;
    }

    public String getFineName() {
        return FineName;
    }

    public void setFineName(String FineName) {
        this.FineName = FineName;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

}

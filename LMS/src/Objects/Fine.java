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

    private String FineID;
    private String FineName;
    private String Description;
    private double Cost;

    public Fine() {

    }

    public Fine(String FineID, String FineName, String Description, double Cost) {
        this.FineID = FineID;
        this.FineName = FineName;
        this.Description = Description;
        this.Cost = Cost;
    }

    public String getFineID() {
        return FineID;
    }

    public void setFineID(String FineID) {
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}

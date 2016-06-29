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
public class Categories {

    private String CateID;
    private String CateName;

    public Categories() {

    }

    public Categories(String CateID, String CateName) {
        this.CateID = CateID;
        this.CateName = CateName;
    }

    public String getCateID() {
        return CateID;
    }

    public void setCateID(String CateID) {
        this.CateID = CateID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

}

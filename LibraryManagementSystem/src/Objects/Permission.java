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
public class Permission {

    private int PermissionID;
    private String PermissionName;

    public Permission() {

    }

    public Permission(int PermissionID, String PermissionName) {
        this.PermissionID = PermissionID;
        this.PermissionName = PermissionName;
    }

    public int getPermissionID() {
        return PermissionID;
    }

    public void setPermissionID(int PermissionID) {
        this.PermissionID = PermissionID;
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String PermissionName) {
        this.PermissionName = PermissionName;
    }

}

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

    private String PermissionID;
    private String PermissionName;

    public Permission() {

    }

    public Permission(String PermissionID, String PermissionName) {
        this.PermissionID = PermissionID;
        this.PermissionName = PermissionName;
    }

    public String getPermissionID() {
        return PermissionID;
    }

    public void setPermissionID(String PermissionID) {
        this.PermissionID = PermissionID;
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String PermissionName) {
        this.PermissionName = PermissionName;
    }

}

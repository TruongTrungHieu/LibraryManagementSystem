/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD5;

import java.security.MessageDigest;

/**
 *
 * @author ELC-17
 */
public class PasswordEncryptor {

    /**
     *
     * this method will return up a series of 32 characters when it is encrypted
     * md5
     *
     * @param clearTextPassword
     * @return
     */
    public static String getEncodedPassword(String clearTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(clearTextPassword.getBytes());
            return HexString.charArrayToHex(md.digest());
        } catch (Exception e) {
            System.out.print("getEncodedPassword: " + e.getMessage());
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELC-17
 */
public class DatabaseProperty {

    public static String Datasourcename;// Data source name when you create to refence database
    public static String Username;// username when you log in sql sever
    public static String Password;// password when you log in sql sever
    public static String Servername;// server name  ex: localhost
    public static String DatabaseName;// database name of your project
    public static int Port;// port when you install sql server
    public static int Type;// standard  connect to the database

    public static FileInputStream fis = null;
    public static FileOutputStream fos = null;

    /**
     * This method will load config to connect to database
     */
    public static void loadconfig() {

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");

            Properties prop = new Properties();
            prop.load(fis);
            Type = Integer.parseInt(prop.getProperty("type"));
            if (Type == 4) {
                Servername = prop.getProperty("servername");
                System.out.println(Servername);
                DatabaseName = prop.getProperty("databasename");
                Port = Integer.parseInt(prop.getProperty("port"));
                Username = prop.getProperty("username");
                Password = prop.getProperty("pass");
            }
            if (Type == 1) {
                Datasourcename = prop.getProperty("datasourcename");
                Username = prop.getProperty("username");
                Password = prop.getProperty("pass");
            }

            /*  prop.put("server","localhost");
            prop.put("user","lab");
            prop.store(fos,null);*/
        } catch (IOException ex) {
            Logger.getLogger(DatabaseProperty.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * this method will save data to config file accoding to 1 standard
     *
     * @param t1
     */
    public static void SaveType1(ConnectType1 t1) {
        try {

            fos = new FileOutputStream(System.getProperty("user.dir") + "/config.properties");
            Properties prop = new Properties();
            prop.put("type", "1");
            prop.put("datasourcename", t1.getTxt_datasourname().getText());
            prop.put("username", t1.getTxt_username().getText());
            prop.put("pass", String.valueOf(t1.getTxt_pass().getPassword()));

            prop.store(fos, null);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseProperty.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * this method will save data to config file accoding to 4 standard
     *
     * @param t4
     */
    public static void SaveType4(ConnectType4 t4) {
        try {

            fos = new FileOutputStream(System.getProperty("user.dir") + "/config.properties");
            Properties prop = new Properties();
            String severname;
            severname = t4.gettxt_severname().getText();
            severname = severname.replace("\\", "\\\\");
            prop.put("type", "4");
            prop.put("servername", t4.gettxt_severname().getText());
            prop.put("databasename", t4.gettxt_databasename().getText());
            prop.put("port", t4.getTxt_port().getText());
            prop.put("username", t4.getTxt_user().getText());
            prop.put("pass", String.valueOf(t4.getTxt_pass().getPassword()));

            prop.store(fos, null);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseProperty.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {

    }
}

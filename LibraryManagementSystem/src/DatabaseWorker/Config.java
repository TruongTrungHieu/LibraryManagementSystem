/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseWorker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ELC-17
 */
public class Config {

    private static String Datasourname;//this varible stores the data source name
    private static String UserName;//this varible stores username when you log in sql sever
    private static String Password;//this varible stores password when you log in sql sever
    private static int Port;//this varible stores port of sql sever
    private static String Servername;//name of sever ex; localhost
    private static String DatabaseName;//database name of your project
    private static String Version;
    public static int type;//type of connection here we use 2 standards :1 standard:odbc- jdbc bridge or directly by 4 standard 

    public static String getDatasourname() {
        return Datasourname;
    }

    public static void setDatasourname(String aDatasourname) {
        Datasourname = aDatasourname;
    }

    public static int getType() {
        return type;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String aUserName) {
        UserName = aUserName;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String aPassword) {
        Password = aPassword;
    }

    public static int getPort() {
        return Port;
    }

    public static void setPort(int aPort) {
        Port = aPort;
    }

    public static String getServername() {
        return Servername;
    }

    public static void setServername(String aServername) {
        Servername = aServername;
    }

    public static String getDatabaseName() {
        return DatabaseName;
    }

    public static void setDatabaseName(String aDatabaseName) {
        DatabaseName = aDatabaseName;
    }

    public static String getVersion() {
        return Version;
    }

    public static void setVersion(String aVersion) {
        Version = aVersion;
    }

    /**
     *
     * this method will save to config file when a user log in the system by 1
     * standard
     *
     * @param t1
     */
    public static void savetype1(ConnectType1 t1) {
        Datasourname = t1.getTxt_datasourname().getText();
        UserName = t1.getTxt_username().getText();
        Password = String.valueOf(t1.getTxt_pass().getPassword());
        type = 1;
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("config.txt"));

            br.write(1 + ";" + Datasourname + ";" + UserName + ";" + Password);
            br.close();

        } catch (Exception e) {

        }
    }

    /**
     *
     * this method will save to config file when a user log in the system by 4
     * standard
     *
     * @param t1
     */
    public static void savetype4(ConnectType4 t1) {
        Servername = t1.gettxt_severname().getText();
        DatabaseName = t1.gettxt_databasename().getText();

        Port = Integer.parseInt(t1.getTxt_port().getText());
        UserName = t1.getTxt_user().getText();
        Password = String.valueOf(t1.getTxt_pass().getPassword());

        type = 4;
        try (BufferedWriter br = new BufferedWriter(new FileWriter("config.txt"))) {
            br.write(4 + ";" + Servername + ";" + DatabaseName + ";" + Port + ";" + UserName + ";" + Password);
        } catch (Exception e) {

        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("config.txt"))) {
            br.write(1 + ";" + Datasourname + ";" + UserName + ";" + Password);
        } catch (Exception e) {

        }
    }

    /**
     *
     * this method will be called to load config when user log in the system
     */
    public static void loadConfig() {
        try {
            String str;
            try (BufferedReader bf = new BufferedReader(new FileReader("config.txt"))) {
                str = bf.readLine();
            }
            String arr[] = str.split(";");
            if (str.startsWith("1;")) {
                Datasourname = arr[1];
                UserName = arr[2];
                Password = arr[3];

            }
            if (str.startsWith("4;")) {
                Servername = arr[1];
                DatabaseName = arr[2];
                Port = Integer.parseInt(arr[3]);
                UserName = arr[4];
                Password = arr[5];
            }

        } catch (IOException | NumberFormatException e) {
            new ConnectDatabase(null, true);
        }
    }
}

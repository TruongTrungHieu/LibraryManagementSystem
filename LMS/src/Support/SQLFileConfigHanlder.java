/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import DatabaseWorker.DatabaseProperty;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ELC-17
 */
public class SQLFileConfigHanlder {

    private static final String FILE_NAME = "SQLFileConfig.txt";

    public static boolean checkFileExisted() {
        try {
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                return true;
            } else {
                return true;
            }
        } catch (IOException e) {
            System.out.print("checkFileExisted: " + e.getMessage());
            return false;
        }
    }

    public static boolean writeConfigFile(DatabaseWorker.DatabaseProperty dbProperty) {
        if (checkFileExisted()) {
            BufferedWriter writer = null;

            try {
                File configFile = new File(FILE_NAME);
                writer = new BufferedWriter(new FileWriter(configFile));

                writer.write(dbProperty.getHostName() + "\n");
                writer.write(dbProperty.getSqlInstanceName() + "\n");
                writer.write(dbProperty.getDatabase() + "\n");
                writer.write(dbProperty.getUserName() + "\n");
                writer.write(dbProperty.getPassword());

                return true;
            } catch (Exception e) {
                System.out.print("writeConfigFile: " + e.getMessage());
                return false;
            } finally {
                try {
                    writer.close();
                    return true;
                } catch (Exception e) {
                    System.out.print("writeConfigFile_closeFile: " + e.getMessage());
                    return false;
                }
            }

        } else {
            return false;
        }
    }

    public static boolean readConfigFile() {
        if (checkFileExisted()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String sCurrentLine;

                String hostName = "";
                String sqlInstanceName = "";
                String database = "";
                String userName = "";
                String password = "";

                int line = 0;
                while ((sCurrentLine = br.readLine()) != null) {
                    switch (line) {
                        case 0:
                            hostName = sCurrentLine;
                            break;
                        case 1:
                            sqlInstanceName = sCurrentLine;
                            break;
                        case 2:
                            database = sCurrentLine;
                            break;
                        case 3:
                            userName = sCurrentLine;
                            break;
                        case 4:
                            password = sCurrentLine;
                            break;
                    }
                    line++;
                }
                Global.DatabaseProperty = new DatabaseProperty(hostName, sqlInstanceName, database, userName, password);
                return true;
            } catch (IOException e) {
                System.out.print("readConfigFile: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
}

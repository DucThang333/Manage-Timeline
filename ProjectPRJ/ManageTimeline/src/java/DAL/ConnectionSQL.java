/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Thang
 */
public class ConnectionSQL {
   private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=ManageTimeline;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123456";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * create connection 
     * 
     * @author viettuts.vn
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
}

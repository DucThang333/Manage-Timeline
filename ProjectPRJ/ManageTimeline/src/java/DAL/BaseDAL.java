/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author AD
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class BaseDAL<T> {
    protected Connection connection;
    public BaseDAL()
    {
        try {
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ManageTimeline";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

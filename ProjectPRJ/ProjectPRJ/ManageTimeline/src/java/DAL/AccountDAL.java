/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.ResultSet;
import java.sql.Statement;
import Model.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class AccountDAL extends BaseDAL<Account>{
    //---- get all -----
  
    public ArrayList<Account> getAll() {
        ArrayList<Account> listAccount = new ArrayList<>();
        // connect
        try {
            // Statement execute to execute sql
            Statement stmt = connection.createStatement();
            //resultSet to contain result execute
            ResultSet rs = stmt.executeQuery("select * from Account");
            // get data
            while (rs.next()) {
                listAccount.add(new Account(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getInt(5),
                        rs.getString(6),rs.getDate(7)));
            }
//            // close
//            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listAccount;
    }
    public Account getAccountByID(String iD){
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement("select * from Account where IDAccount = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iD);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            if(rs.next()){
                return new Account(rs.getString(1),rs.getString(2)
                        ,rs.getString(3),rs.getString(4),rs.getInt(5)
                        ,rs.getString(6),rs.getDate(7));
            }
//            // close
//            conn.close();
        } catch (SQLException ex) {
        }
        return null;
    }
    public Account existAccount(String username , String password){
        Account acc = getAccountByUsername(username);
        try {
            if(acc.getUserName().equals(username) && acc.getPassword().equals(password)){
                return acc;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    public  Account getAccountByUsername(String name){
                try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement("select * from Account where usernameAccount = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1,name);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            if(rs.next()){
                return new Account(rs.getString(1),rs.getString(2)
                        ,rs.getString(3),rs.getString(4),rs.getInt(5),
                        rs.getString(6),rs.getDate(7));
            }
//            // close
//            conn.close();
        } catch (SQLException ex) {
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
// -----------test process------------  
//    public static void main(String[] args) {
//        AccountDAL d = new AccountDAL();
////         test getAll
//        for (Account acc : d.getAll()) {
//            System.out.println(acc);
//        }
//        System.out.println("---------------");
////      test getAccountByID
//        System.out.println(d.getAccountByID("0234"));
//    // test getAccountByUsername
//        System.out.println(d.getAccountByUsername("hai123"));
//    }
}

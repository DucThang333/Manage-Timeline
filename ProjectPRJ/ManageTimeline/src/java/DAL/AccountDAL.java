/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Account;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class AccountDAL {
    //---- get all -----
    public ArrayList<Account> getAll() {
        ArrayList<Account> listAccount = new ArrayList<>();
        // connect
        try {
            Connection conn = ConnectionSQL.getConnection();
            // Statement execute to execute sql
            Statement stmt = conn.createStatement();
            //resultSet to contain result execute
            ResultSet rs = stmt.executeQuery("select * from Account");
            // get data
            while (rs.next()) {
                listAccount.add(new Account(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
            }
            // close
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listAccount;
    }
    public Account getAccountByID(String iD){
        try {
            Connection conn = ConnectionSQL.getConnection();
            PreparedStatement PreStmt = conn.prepareStatement("select * from Account where IDAccount = ?");
            PreStmt.setString(1, iD);
            ResultSet rs = PreStmt.executeQuery();
            // get data
            if(rs.next()){
                return new Account(rs.getString(1),rs.getString(2)
                        ,rs.getString(3),rs.getInt(4),rs.getString(5));
            }
            // close
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
// -----------test process------------  
    public static void main(String[] args) {
        AccountDAL d = new AccountDAL();
//         test getAll
//        for (Account acc : d.getAll()) {
//            System.out.println(acc);
//        }
//      test getAccountByID
        System.out.println(d.getAccountByID("0"));
    }
}

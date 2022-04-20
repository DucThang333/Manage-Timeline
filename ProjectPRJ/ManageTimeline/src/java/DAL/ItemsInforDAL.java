/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.ItemsInfor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Thang
 */
public class ItemsInforDAL extends BaseDAL<ItemsInfor>{
 
    public ArrayList<ItemsInfor> getAll(String iDAccount) {
        ArrayList<ItemsInfor> listItemsInfor = new ArrayList<>();
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement("select * from ItemsInfor where IDAccount = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            while (rs.next()) {
               listItemsInfor.add(new ItemsInfor(rs.getString(1),rs.getString(3)
                       ,rs.getDate(4),rs.getDate(5),rs.getString(6)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listItemsInfor;
    }
    
    
    public Date getMaxdate(String iDAccount){
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "select max(DateEnd)from ItemsInfor where IDAccount = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            while (rs.next()) {
               return rs.getDate(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
   // test running
//    public static void main(String[] args) {
//        ItemsInforDAL i = new ItemsInforDAL();
//        for (ItemsInfor itemsInfor : i.getAll("022")) {
//            System.out.println(itemsInfor);
//        }
//        System.out.println(i.getMaxdate("022"));
//    }
}

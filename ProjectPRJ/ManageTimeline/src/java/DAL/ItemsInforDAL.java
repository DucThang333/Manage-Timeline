/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.ItemsInfor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class ItemsInforDAL extends BaseDAL<ItemsInfor> {

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
                listItemsInfor.add(new ItemsInfor(rs.getString(1), rs.getString(3),
                        rs.getDate(4), rs.getDate(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
        }
        return listItemsInfor;
    }

    public ArrayList<ItemsInfor> getAllOrderByDate(String iDAccount) {
        ArrayList<ItemsInfor> listItemsInfor = new ArrayList<>();
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement("select * from ItemsInfor where IDAccount = ?  order by DateStart,dateEnd");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            while (rs.next()) {
                listItemsInfor.add(new ItemsInfor(rs.getString(1), rs.getString(3),
                        rs.getDate(4), rs.getDate(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
        }
        return listItemsInfor;
    }

    public Date getMaxdate(String iDAccount) {
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
        } catch (SQLException ex) {
        }
        return null;
    }

    public ItemsInfor getItemsInforByID(String iDAccount, String iDItems) {
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "select * from ItemsInfor where IDAccount = ? and IDItems = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            PreStmt.setString(2, iDItems);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            while (rs.next()) {
                return new ItemsInfor(rs.getString(1), rs.getString(3),
                        rs.getDate(4), rs.getDate(5), rs.getString(6));
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public boolean createTtemsInfor(ItemsInfor itemsInfor , String iDAccount) {
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "insert into ItemsInfor values(?,?,?,?,?,?)");
            // PreparedStatement set place(?)
            PreStmt.setString(1, itemsInfor.getID());
            PreStmt.setString(2, iDAccount);
            PreStmt.setString(3, itemsInfor.getTitle());
            PreStmt.setDate(4, itemsInfor.getDateStart());
            PreStmt.setDate(5, itemsInfor.getDateEnd());
            PreStmt.setString(6, itemsInfor.getDetail());
            // Resuilt to contain result execute
            PreStmt.execute();
            return true;
        } catch (SQLException ex) {
        }
        return false; 
    }

    // test running
//    public static void main(String[] args) {
//        ItemsInforDAL i = new ItemsInforDAL();
//        Date newdate = new Date(2000-05-15);
//         Date newdate1 = new Date(2000-05-15);
//        i.createTtemsInfor(new ItemsInfor("100011","newItem"
//                , newdate,newdate1, "s"),"022");
//        
//        for (ItemsInfor itemsInfor : i.getAll("022")) {
//            System.out.println(itemsInfor);
//        }
//        System.out.println(i.getMaxdate("022"));
//        System.out.println(i.getItemsInforByID("022","2222"));
//    }
//    
}

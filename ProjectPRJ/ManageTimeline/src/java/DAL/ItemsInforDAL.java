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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                        rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7)));
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
                        rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
        }
        return listItemsInfor;
    }

    public ArrayList<ItemsInfor> getAlByTitleDate(String iDAccount, String title, Date date) {
        ArrayList<ItemsInfor> listItemsInfor = new ArrayList<>();
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(""
                    + "select * from ItemsInfor where IDAccount = ? and title = ? and dateStart = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            PreStmt.setString(2, title);
            PreStmt.setDate(3, date);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            while (rs.next()) {
                listItemsInfor.add(new ItemsInfor(rs.getString(1), rs.getString(3),
                        rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            return null;
        }
        return listItemsInfor;
    }

    public ArrayList<String> getAllIdentify(String iDAccount) {
        ArrayList<String> listIdentify = new ArrayList<>();
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "	select title , dateStart from ItemsInfor where IDAccount = ? order by title ,dateStart;");

            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            // Resuilt to contain result execute
            ResultSet rs = PreStmt.executeQuery();
            // get data
            while (rs.next()) {
                listIdentify.add(" ' " + rs.getString(1) + "   " + rs.getDate(2) + " ' ");
            }
        } catch (SQLException ex) {
        }
        return listIdentify;
    }

    public static void main(String[] args) {
        ItemsInforDAL i = new ItemsInforDAL();
        for (String stri : i.getAllIdentify("022")) {
            System.out.println(stri);
        }
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
                        rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public boolean createItemsInfor(ItemsInfor itemsInfor, String iDAccount) {
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "insert into ItemsInfor values(?,?,?,?,?,?,?)");
            // PreparedStatement set place(?)
            PreStmt.setString(1, itemsInfor.getID());
            PreStmt.setString(2, iDAccount);
            PreStmt.setString(3, itemsInfor.getTitle());
            PreStmt.setDate(4, itemsInfor.getDateStart());
            PreStmt.setDate(5, itemsInfor.getDateEnd());
            PreStmt.setString(6, itemsInfor.getDetail());
            PreStmt.setString(7, itemsInfor.getBackground());
            // Resuilt to contain result execute
            PreStmt.execute();
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean updateItemsInfor(ItemsInfor itemsInfor, String iDAccount) {
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "	UPDATE ItemsInfor\n"
                    + "	SET Title = ? ,DateStart = ?,DateEnd = ?, Detail  = ? ,Background = ? \n"
                    + "	WHERE IDItems = ? and IDAccount = ?;");
            // PreparedStatement set place(?)
            PreStmt.setString(1, itemsInfor.getTitle());
            PreStmt.setDate(2, itemsInfor.getDateStart());
            PreStmt.setDate(3, itemsInfor.getDateEnd());
            PreStmt.setString(4, itemsInfor.getDetail());
            PreStmt.setString(5, itemsInfor.getBackground());
            PreStmt.setString(6, itemsInfor.getID());
            PreStmt.setString(7, iDAccount);
            // Resuilt to contain result execute
            PreStmt.execute();
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public void deleteItemsInfor(String iDItemsInfor, String iDAccount) {
        // connect
        try {
            // PreparedStatement prepare execute
            PreparedStatement PreStmt = connection.prepareStatement(
                    "delete from ItemsInfor where IDAccount = ? and IDItems = ?");
            // PreparedStatement set place(?)
            PreStmt.setString(1, iDAccount);
            PreStmt.setString(2, iDItemsInfor);
            // Resuilt to execute
            PreStmt.execute();
            // get data
        } catch (SQLException ex) {
        }
    }

    // test running
//    public static void main(String[] args) {
//        ItemsInforDAL i = new ItemsInforDAL();
////        Date dt1 = new Date(i.getDate("2005-2-2").getTime());
////        Date dt2 = new Date(i.getDate("2007-2-2").getTime());
////        System.out.println( i.createItemsInfor(new ItemsInfor("100015","newItem"
////                ,dt1,dt2, "s"),"022"));
//        
//        for (ItemsInfor itemsInfor : i.getAll("022")) {
//            System.out.println(itemsInfor);
//        }
//        i.deleteItemsInfor("100015","022");
//        for (ItemsInfor itemsInfor : i.getAll("022")) {
//            System.out.println(itemsInfor);
//        }
//        System.out.println(i.getMaxdate("022"));
//        System.out.println(i.getItemsInforByID("022","2222"));
//    }
//        public java.util.Date getDate(String dt2) {
//        java.util.Date newdate = new java.util.Date();
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            newdate = sdf.parse(dt2);
//        } catch (ParseException e) {
//        }
//        return newdate;
//    }
//    
}

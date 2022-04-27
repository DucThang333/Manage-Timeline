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
                        rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getBoolean(9)));
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
                        rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getBoolean(9)));
            }
        } catch (SQLException ex) {
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
                    "insert into ItemsInfor values(?,?,?,?,?,?,?,?,?)");
            // PreparedStatement set place(?)
            PreStmt.setString(1, itemsInfor.getID());
            PreStmt.setString(2, iDAccount);
            PreStmt.setString(3, itemsInfor.getTitle());
            PreStmt.setDate(4, itemsInfor.getDateStart());
            PreStmt.setDate(5, itemsInfor.getDateEnd());
            PreStmt.setString(6, itemsInfor.getDetail());
            PreStmt.setString(7, itemsInfor.getBackground());
            PreStmt.setString(8,itemsInfor.getTypeInfor());
            PreStmt.setBoolean(9, false);
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
                    + "	SET Title = ? ,DateStart = ?,DateEnd = ?, Detail  = ? ,Background = ?,typeItems = ? \n"
                    + "	WHERE IDItems = ? and IDAccount = ?;");
            // PreparedStatement set place(?)
            PreStmt.setString(1, itemsInfor.getTitle());
            PreStmt.setDate(2, itemsInfor.getDateStart());
            PreStmt.setDate(3, itemsInfor.getDateEnd());
            PreStmt.setString(4, itemsInfor.getDetail());
            PreStmt.setString(5, itemsInfor.getBackground());
            PreStmt.setString(6, itemsInfor.getTypeInfor());
            PreStmt.setString(7, itemsInfor.getID());
            PreStmt.setString(8, iDAccount);
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
}

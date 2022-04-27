/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.TypeInfor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class TypeInforDAL extends BaseDAL<TypeInfor> {

    public ArrayList<TypeInfor> getAllType() {
        ArrayList<TypeInfor> ls = new ArrayList<>();
        try {
            PreparedStatement ptmst = connection.prepareStatement("select * from typeInfor");
            ResultSet rs = ptmst.executeQuery();
            while (rs.next()) {
                ls.add(new TypeInfor(rs.getString(1), rs.getString(2)));
            }
            return ls;
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean creatType(String name, String detail) {
        ArrayList<TypeInfor> ls = new ArrayList<>();
        try {
            PreparedStatement ptmst = connection.prepareStatement("insert into typeInfor\n"
                    + "	values(?,?) ");
            ptmst.setString(1, name);
            ptmst.setString(2, detail);
            ptmst.execute();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
}

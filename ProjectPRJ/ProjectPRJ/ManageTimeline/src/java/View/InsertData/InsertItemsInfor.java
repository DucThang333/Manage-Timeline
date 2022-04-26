/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.InsertData;

import DAL.ItemsInforDAL;
import Model.ItemsInfor;
import java.sql.Date;

/**
 *
 * @author Thangs
 */
public class InsertItemsInfor {

    public boolean checkInvalid(ItemsInfor itemsInfor, String iDAccount) {
        Date dateNow = new Date(System.currentTimeMillis());
        ItemsInforDAL intemDAL = new ItemsInforDAL();
        setIDItemsInfor(itemsInfor, iDAccount, dateNow.getTime());
        if (!checkDate(dateNow, itemsInfor.getDateStart(), itemsInfor.getDateEnd())) {
            return false;
        } else if (!intemDAL.createItemsInfor(itemsInfor, iDAccount)) {
            return false;
        }
        return true;
    }

    private void setIDItemsInfor(ItemsInfor itemsInfor, String iDAccount, long time) {
        itemsInfor.setID(String.valueOf(time));
    }

    public boolean checkDate(Date dateNow, Date dateStart, Date dateEnd) {
        if (dateStart.getTime() < dateNow.getTime()) {
            return false;
        } else if (dateEnd.getTime() < dateStart.getTime()) {
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        InsertItemsInfor i = new InsertItemsInfor();
//        Date dt1 = new java.sql.Date(i.getDate("2022-10-10").getTime());
//        Date dt2 = new java.sql.Date(i.getDate("2022-11-10").getTime());
//        System.out.println(i.checkInvalid(new ItemsInfor("newTime", dt1, dt2,
//                "01234566"), "022"));
//    }

//    public java.util.Date getDate(String dt2) {
//        java.util.Date newdate = new java.util.Date();
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            newdate = sdf.parse(dt2);
//        } catch (ParseException e) {
//        }
//        return newdate;
//    }
}

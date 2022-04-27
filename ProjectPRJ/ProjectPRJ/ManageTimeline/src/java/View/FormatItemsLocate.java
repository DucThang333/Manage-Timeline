/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAL.ItemsInforDAL;
import Model.ItemsInfor;
import View.ModelView.ItemsLocate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thang
 */
public class FormatItemsLocate {

    public ArrayList<ItemsLocate> getArrayItemsLocate(String iDAccount, Date dateJoin, int type) {
        ItemsInforDAL intemsDAL = new ItemsInforDAL();
        ArrayList<ItemsInfor> listInfors = intemsDAL.getAllOrderByDate(iDAccount);
        ArrayList<ItemsLocate> listItemsLocates = new ArrayList<>();
        for (ItemsInfor infor : listInfors) {
            listItemsLocates.add(getItemsLocate(infor, dateJoin, type));
        }
        return listItemsLocates;
    }

    private ItemsLocate getItemsLocate(ItemsInfor itemsInfor, Date dateJoin, int type) {
        int dayDistance = getDayBetween(itemsInfor.getDateStart(), dateJoin);
        int dayBetween = getDayBetween(itemsInfor.getDateEnd(), itemsInfor.getDateStart());
        int dateNow = getDayBetween(new Date(), itemsInfor.getDateStart());
        return new ItemsLocate(itemsInfor.getID(), dayBetween, dayDistance, dateNow, type, 1, itemsInfor.getBackground());
    }

    public int getScrolltop(Date dateJoin, int type) {
        int multi = 0;
        switch (type) {
            case 1:
                multi = 48;
                break;
            case 2:
                multi = 24;
                break;
            default:
                multi = 8;
                break;
        }
        return getDayBetween(new Date(), dateJoin)*multi + 3;
    }

    private int getDayBetween(Date dateMax, Date dateJoin) {
        return (int) ((dateMax.getTime() - dateJoin.getTime()) / (1000 * 3600 * 24));
    }
    // test running
//    public static void main(String[] args) {
//        FormatItemsLocate ft = new FormatItemsLocate();
//        ArrayList<ItemsLocate> ls = ft.getArrayItemsLocate("022",ft.getDate(),2);
//        for (ItemsLocate l : ls) {
//            System.out.println(l);
//        }
//    }
//    

}

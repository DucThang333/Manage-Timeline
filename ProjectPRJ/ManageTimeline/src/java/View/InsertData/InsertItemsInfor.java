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
 * @author Thang
 */
public class InsertItemsInfor {

    public boolean checkInvalid(ItemsInfor itemsInfor, Date dateNow , String iDAccount) {
        ItemsInforDAL intemDAL = new ItemsInforDAL();
        if(!checkDate(dateNow, itemsInfor.getDateStart(), itemsInfor.getDateEnd())){
            return false;
        }else if(intemDAL.createTtemsInfor(itemsInfor, iDAccount)){
            return false;
        }
        
        return true;
    }

    private boolean checkDate(Date dateNow, Date dateStart, Date dateEnd) {
        if (dateStart.getTime() < dateNow.getTime()) {
            return false; 
        }else if(dateEnd.getTime() < dateStart.getTime()){
            return false;
        }
        return true;
    }
}

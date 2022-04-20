/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAL.ItemsInforDAL;
import View.ModelView.Timeline;
import java.util.Date;



/**
 *
 * @author Thang
 */
public class FormatTimeline {
    // get convert day to px
    private int styleTimeline(String iDAccount ,Date dateJoin){
        ItemsInforDAL item = new ItemsInforDAL();
        Date dateMax = item.getMaxdate(iDAccount);
        if(dateMax == null)return 12;
        long diff = dateMax.getTime() - dateJoin.getTime();
        long dayBetween = diff/(1000 * 60 * 60 * 24);
        if(dayBetween <= 189){
            //small per day with 12px
            return 12;
        }else if(dayBetween >= 189 && dayBetween <=378){
            // medium per day with 3px
            return 6;
        }else{
            // big per day with 2px
            return 3;
        }
    }
    // get convert day to px
    
    public Timeline getTimesLoop(String iDAccount ,Date dateJoin , Date dateMax){
        int times = styleTimeline(iDAccount, dateJoin);
        if(times == 12 && dateMax)
        return new Timeline(times, times);
        
    }
    
    // test running
    public static void main(String[] args) {
        FormatTimeline t = new FormatTimeline();
        Date dNow = new Date();
        System.out.println(dNow.getTime());
        t.styleTimeline("022",dNow);

    }
}

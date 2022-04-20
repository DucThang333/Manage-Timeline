/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAL.ItemsInforDAL;
import View.ModelView.Timeline;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thang
 */
public class FormatTimeline {

    // get timesline
    public Timeline getTimesline(String iDAccount, Date dateJoin) {
        ItemsInforDAL item = new ItemsInforDAL();
        Date dateMax = item.getMaxdate(iDAccount);
        if (dateMax == null) {
            return new Timeline(12, 60, 1, dateJoin, 1);
        }
        long diff = dateMax.getTime() - dateJoin.getTime();
        int dayBetween = (int) (diff / (1000 * 60 * 60 * 24));
        if (dayBetween < 60) {
            return new Timeline(12, 60, 1, dateJoin, 1);
        } else if (dayBetween >= 60 && dayBetween <= 189) {
            return new Timeline(12, dayBetween, 1, dateJoin, 1);
        } else if (dayBetween >= 189 && dayBetween <= 378) {
            return new Timeline(6, dayBetween / 2, 2, dateJoin, 2);
        } else {
            return new Timeline(2, dayBetween / 6, 6, dateJoin, 3);
        }
    }

    // test running
//    public static void main(String[] args) throws ParseException {
//        String dt1 = "2008-01-01";  // Start date
//        String dt2 = "2008-01-01";  // Start date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Timeline tim = new Timeline(12,6,2,sdf.parse(dt2),2);
//        System.out.println(tim.getNextDate(100));
//    }
}

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

    // get timesline
    public Timeline getTimesline(String iDAccount, Date dateJoin) {
        try {
            ItemsInforDAL item = new ItemsInforDAL();
            Date dateMax = item.getMaxdate(iDAccount);
            if (dateMax == null) {
                return new Timeline(30, dateJoin, 1);
            }
            int dayBetween = getDayBetween(dateMax, dateJoin);
            System.out.println(dayBetween);
            if (dayBetween < 60) {
                return new Timeline(30, dateJoin, 1);
            } else if (dayBetween >= 60 && dayBetween <= 189) {
                return new Timeline(dayBetween + 10, dateJoin, 1);
            } else if (dayBetween >= 189 && dayBetween <= 378) {
                return new Timeline(dayBetween / 2 + 10, dateJoin, 2);
            } else {
                return new Timeline(dayBetween / 6 + 10, dateJoin, 6);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public int getDayBetween(Date dateMax, Date dateJoin) {
        return (int) ((dateMax.getTime() - dateJoin.getTime()) / (1000 * 3600 * 24));
    }

    // test running
//    public static void main(String[] args) throws ParseException {
//        String dt1 = "2008-01-01";  // Start date
//        String dt2 = "2008-01-01";  // Start date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        FormatTimeline f = new FormatTimeline();
//        Timeline tim = f.getTimesline("022", f.getDate());
//        System.out.println(tim.getType());
//    }
//
//        public Date getDate() {
//        Date newdate = new Date();
//        try {
//            String dt2 = "2024-05-15";  // Start date
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            newdate = sdf.parse(dt2);
//        } catch (ParseException e) {
//        }
//        return newdate;
//    }
}

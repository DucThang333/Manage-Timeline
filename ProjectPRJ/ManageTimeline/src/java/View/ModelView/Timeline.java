/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ModelView;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Thang
 */
public class Timeline {

    // unit times
    private int segmentNumber;
    // type (1,2,3..)
    private int type;
    // date join
    private Date dateJoin;
    // line
    private boolean line;
    private int monthIndex;
    private int monthAfter;

    public Timeline() {
    }

    public Timeline(int segmentNumber, Date dateJoin, int type) {
        this.segmentNumber = segmentNumber;
        this.dateJoin = dateJoin;
        this.type = type;
        this.line = false;
        setMonth();
    }

    public void setDateJoin(Date dateJoin) {
        this.dateJoin = dateJoin;
    }

    public Date getDateJoin() {
        return dateJoin;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSegmentNumber() {
        return segmentNumber;
    }

    public void setSegmentNumber(int segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    public void setLine(boolean line) {
        this.line = line;
    }
    
    public boolean getLine(){
        return line;
    }

    public int getMonthIndex() {
        return monthIndex;
    }

    public void setMonthIndex(int monthIndex) {
        this.monthIndex = monthIndex;
    }

    public int getMonthAfter() {
        return monthAfter;
    }

    public void setMonthAfter(int monthAfter) {
        this.monthAfter = monthAfter;
    }
    
    

    public String getNextDate(int datePlus) {
        datePlus = datePlus*type;
        setLine(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateJoin);
        calendar.add(Calendar.DATE, datePlus);
        if((monthAfter%12) != calendar.get(Calendar.MONTH)){
            monthAfter = monthAfter + 1;
        }
        if(monthAfter == (monthIndex + type)){
            setMonthIndex(monthAfter);
            setLine(true);
        }
        return sdf.format(calendar.getTime());
    }
    
    private void setMonth(){
         Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateJoin);
        monthAfter = monthIndex = calendar.get(Calendar.MONTH);
    }
}

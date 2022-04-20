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

    // unit px
    private int pixel;
    // unit times
    private int segmentNumber;
    // unit 1 month
    private int tick;
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

    public Timeline(int pixel, int segmentNumber, int tick, Date dateJoin, int type) {
        this.pixel = pixel;
        this.segmentNumber = segmentNumber;
        this.tick = tick;
        this.dateJoin = dateJoin;
        this.type = type;
        this.line = false;
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

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    public int getSegmentNumber() {
        return segmentNumber;
    }

    public void setSegmentNumber(int segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
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
        if(type == 2){
            datePlus*=2;
        }else if(type == 2){
            datePlus*=6;
        }
        setLine(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateJoin);
        calendar.add(Calendar.DATE, datePlus);
        if(monthAfter != calendar.get(Calendar.MONTH)){
            setMonthAfter(monthAfter + 1);
        }
        if((type == 1 && monthAfter == (monthIndex + 1)) || 
            (type == 2 && monthAfter == (monthIndex + 2)) ||
                (type == 3 && monthAfter == (monthIndex + 6))){
            setMonthIndex(monthAfter);
            setLine(true);
        }
        return sdf.format(calendar.getTime());
    }

}

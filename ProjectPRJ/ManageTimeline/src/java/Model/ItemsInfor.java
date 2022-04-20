/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Thang
 */
public class ItemsInfor {
    private String iD;
    private String title;
    private Date dateStart;
    private Date dateEnd;
    private String detail;

    public ItemsInfor() {
    }

    public ItemsInfor(String iD, String title, Date dateStart, Date dateEnd, String detail) {
        this.iD = iD;
        this.title = title;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.detail = detail;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    


    @Override
    public String toString() {
        return iD + " | " + title + " | " + dateStart +" | " + dateEnd + " | " + detail; 
    }
    
}

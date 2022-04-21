/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ModelView;

/**
 *
 * @author Thang
 */
public class ItemsLocate {
    private String iD;
    // unit day
    private int heigth;
    //  unit day
    private int distance;
    private int type;
    private int degree;

    public ItemsLocate() {
    }

    public ItemsLocate(String iD, int heigth, int distance, int type, int degree) {
        this.iD = iD;
        this.heigth = heigth;
        this.distance = distance;
        this.type = type;
        this.degree = degree;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {      
        this.iD = iD;        
    }

    public int getDistance() {
        return distance;  
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ItemsLocate{" + "iD=" + iD + ", heigth=" + heigth + ", distance=" + distance + ", type=" + type + ", degree=" + degree + '}';
    }    
}

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

    public ItemsLocate(String iD, int dayBetween, int dayDistance, int type, int degree) {
        this.iD = iD;
        setHeigth(dayBetween);
        setDistance(dayDistance);
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

    private void setDistance(int dayDistance) {
        this.distance = changeDatetoPx(dayDistance);
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

    private void setHeigth(int dayBetween) {
        this.heigth = changeDatetoPx(dayBetween);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int changeDatetoPx(int day) {
        switch (type) {
            case 1:
                return day * 48 + 1;
            case 2:
                return day * 24 + 1;
            default:
                return day * 8 + 1;
        }
    }

    @Override
    public String toString() {
        return "ItemsLocate{" + "iD=" + iD + ", heigth=" + heigth + ", distance=" + distance + ", type=" + type + ", degree=" + degree + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ModelView;

/**
 *
 * @author Thang
 */
public class Timeline {
    private int pixel;
    private int segmentNumber;

    public Timeline() {
    }

    public Timeline(int pixel, int segmentNumber) {
        this.pixel = pixel;
        this.segmentNumber = segmentNumber;
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
}

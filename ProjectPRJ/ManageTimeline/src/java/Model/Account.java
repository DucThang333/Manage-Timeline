/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Thang
 */
public class Account {
    private String iD;
    private String name;
    private String userName;
    private String password;
    private int phone;
    private String imageURL;

    public Account() {
    }

    public Account(String iD, String name, String userName, String password, int phone, String imageURL) {
        this.iD = iD;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.imageURL = imageURL;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    @Override
    public String toString() {
        return iD+ " | " + userName + " | " + password + " | " + phone + " | " + imageURL ;
    }
    
}

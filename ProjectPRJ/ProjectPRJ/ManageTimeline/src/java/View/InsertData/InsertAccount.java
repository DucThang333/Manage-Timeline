/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.InsertData;

import DAL.AccountDAL;
import Model.Account;
import java.sql.Date;

/**
 *
 * @author Thang
 */
public class InsertAccount {

    public boolean insertData(Account acc) {
        Date dateJoin = new Date(System.currentTimeMillis());
        AccountDAL accDAL = new AccountDAL();
        return accDAL.createAccount(acc, getIDACcount(), dateJoin);
    }

    private String getIDACcount() {
        java.util.Date dateJoinJava = new java.util.Date();
        String date = String.valueOf(dateJoinJava);
        date = date.replace(" ICT ", "");
        date = date.substring(4);
        date = date.replaceAll(" ", "");
        date = date.replaceAll(":", ""); 
        return date;
    }

//    public static void main(String[] args) {
//        InsertAccount i = new InsertAccount();
//        i.insertData(null);
//    }
}

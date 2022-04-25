/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.ItemsInforDAL;
import Model.ItemsInfor;
import View.InsertData.InsertItemsInfor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class updateItemsInforServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String IDItem = request.getParameter("IDItemUpdate");
        String title = request.getParameter("titleUpdate");
        String dateStart = request.getParameter("dateStartUpdate");
        String dateEnd = request.getParameter("dateEndUpdate");
        String detail = request.getParameter("detailUpdate"); 
        Date dateSt = Date.valueOf(dateStart);
        Date dateEn = Date.valueOf(dateEnd);
        InsertItemsInfor insertData = new InsertItemsInfor();
        Date dateNow = new Date(System.currentTimeMillis());
        if(insertData.checkDate(dateNow, dateSt, dateEn)){
            out.print("update false");
            return;
        };
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search-update").trim();
        if (search.length() < 11) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        String title = search.substring(0, search.length() - 11).trim();
        Cookie[] cookie = request.getCookies();
        Cookie C_iDAccount = loginServlet.getCookie(cookie, "IDAccount");
        String dateStart = search.substring(search.length() - 10, search.length()).trim();
        Date date = Date.valueOf(dateStart);
        ItemsInforDAL itemsDAL = new ItemsInforDAL();
        ArrayList<ItemsInfor> items = itemsDAL.getAlByTitleDate(C_iDAccount.getValue(), title, date);
        if (items != null) {
            request.setAttribute("checkFindUpdate", true);
        }
        request.setAttribute("listItemsUpdate", items);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

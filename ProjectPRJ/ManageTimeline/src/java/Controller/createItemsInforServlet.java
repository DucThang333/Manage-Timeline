/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Thang
 */
public class createItemsInforServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookie = request.getCookies();
        String iDAccount = loginServlet.getCookie(cookie, "IDAccount").getValue();
        String title = request.getParameter("createTitle");
        Date dateStart = new Date(getDate(request.getParameter("createDateStart")).getTime());
        Date dateEnd =new Date(getDate(request.getParameter("createDateEnd")).getTime());
        String description = request.getParameter("createDescription");
        String backround = request.getParameter("bgfile");
        if("null".equals(backround)){
            backround = request.getParameter("bgColor");
        }
        InsertItemsInfor insert = new InsertItemsInfor();  
        request.setAttribute("createH",insert.checkInvalid(new ItemsInfor(title, dateStart, dateEnd, description ,backround), iDAccount));
        request.getRequestDispatcher("home").forward(request, response);
    }
    
    private java.util.Date getDate(String dt2) {
        java.util.Date newdate = new java.util.Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            newdate = sdf.parse(dt2);
        } catch (ParseException e) {
        }
        return newdate;
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
        processRequest(request, response);
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
        processRequest(request, response);
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

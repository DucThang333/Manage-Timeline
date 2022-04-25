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
        String search = request.getParameter("search-update").trim();
        Cookie[] cookie = request.getCookies();
        Cookie C_iDAccount = loginServlet.getCookie(cookie, "IDAccount");
        ItemsInforDAL itemsDAL = new ItemsInforDAL();
        ArrayList<ItemsInfor> iemsUpdate = new ArrayList<>();
        for (ItemsInfor item : itemsDAL.getAll(C_iDAccount.getValue())) {
            if ((item.getTitle() + "   " + item.getDateStart()).contains(search)) {
                iemsUpdate.add(item);
            }
        }
        if (!iemsUpdate.isEmpty()) {
            request.setAttribute("checkFindUpdate", true);
        }
        request.setAttribute("listItemsUpdate", iemsUpdate);
        request.getRequestDispatcher("home").forward(request, response); 

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
        String IDItem = request.getParameter("IDItemUpdate");
        String title = request.getParameter("titleUpdate");
        String dateStart = request.getParameter("dateStartUpdate");
        String dateEnd = request.getParameter("dateEndUpdate");
        String detail = request.getParameter("detailUpdate");
        String background = request.getParameter("bgfileUpdate");
        Cookie[] cookie = request.getCookies();
        Cookie C_iDAccount = loginServlet.getCookie(cookie, "IDAccount");
        if (background.equals("")) {
            background = request.getParameter("bgColorUpdate");
        }
        Date dateSt = Date.valueOf(dateStart);
        Date dateEn = Date.valueOf(dateEnd);
        InsertItemsInfor insertData = new InsertItemsInfor();
        Date dateNow = new Date(System.currentTimeMillis());
        if (!insertData.checkDate(dateNow, dateSt, dateEn)) {
            request.getRequestDispatcher("home").forward(request, response);
            return;
        }
        ItemsInforDAL itemDAL = new ItemsInforDAL();
        request.setAttribute("checkUpdate", itemDAL.updateItemsInfor(new ItemsInfor(IDItem, title, dateSt, dateEn, detail, background), C_iDAccount.getValue()));
        request.setAttribute("doUpdate", true);
        request.setAttribute("checkFindUpdate", false);
        request.getRequestDispatcher("home").forward(request, response);
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

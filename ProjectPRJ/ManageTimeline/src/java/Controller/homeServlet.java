/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import View.FormatItemsLocate;
import View.FormatTimeline;
import View.ModelView.ItemsLocate;
import View.ModelView.Timeline;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thang
 */
public class homeServlet extends HttpServlet {

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
        // get session
        HttpSession session = request.getSession();
        String iDAccount = (String) session.getAttribute("iDAccount");
        Date dateJoin = (Date) session.getAttribute("dateJoin");
        // set timeline ---
        FormatTimeline fTimeline = new FormatTimeline();
        Timeline timeline = fTimeline.getTimesline(iDAccount, dateJoin);
        timeline.setMonth();
        
        // set data items ----
        FormatItemsLocate fItemsLocate = new FormatItemsLocate();
        ArrayList<ItemsLocate> listItemsLocate = 
                fItemsLocate.getArrayItemsLocate(iDAccount, dateJoin,timeline.getType());
        
        // set attribute
        request.setAttribute("timeline", timeline);
        request.setAttribute("listItemsLocate",listItemsLocate);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

//    public Date getDate() {
//        Date newdate = new Date();
//        try {
//            String dt2 = "2025-05-15";  // Start date
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            newdate = sdf.parse(dt2);
//        } catch (ParseException e) {
//        }
//        return newdate;
//    }
 

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

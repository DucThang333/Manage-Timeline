/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.AccountDAL;
import Model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author Thang
 */
public class loginServlet extends HttpServlet {

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

    public static Cookie getCookie(Cookie[] cookie, String nameCookie) {
        if (cookie == null) {
            return null;
        } else {
            for (Cookie coo : cookie) {
                if (coo.getName().equals(nameCookie)) {
                    return coo;

                }
            }
        }
        return null;
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
        Cookie[] cookies = request.getCookies();
        request.setAttribute("name",getCookie(cookies,"username").getValue());
        for (Cookie coo : cookies) {
            coo.setMaxAge(0);
            response.addCookie(coo);
        }
        request.getRequestDispatcher("login.jsp").include(request, response);
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
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        AccountDAL accDAL = new AccountDAL();
        Account acc = accDAL.existAccount(username, password);
        if (acc != null) {
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie C_Username = new Cookie("username", username);
                Cookie C_IDAccount = new Cookie("IDAccount", acc.getID());
                C_Username.setMaxAge(3600);
                C_IDAccount.setMaxAge(3600);
                response.addCookie(C_Username);
                response.addCookie(C_IDAccount);
            }
            // get session iDAccount
            response.sendRedirect("home");
        } else {
            request.setAttribute("errorLogin", "Wrong username or password please re-login");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } 
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

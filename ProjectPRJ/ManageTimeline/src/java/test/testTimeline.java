///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package test;
//
//
//import View.ModelView.Timeline;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// *
// * @author Thang
// */
//
//public class testTimeline extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
////    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////            /* TODO output your page here. You may use following sample code. */
////            Timeline tim = new Timeline(30, 1,getDate(), 1);
////            tim.setMonth();
////            request.setAttribute("timeline", tim);
////            request.getRequestDispatcher("home.jsp").forward(request, response);
////    }
////    
////    public Date getDate() {
////        Date newdate = new Date();
////        try {
////            String dt2 = "2008-05-15";  // Start date
////            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////            newdate = sdf.parse(dt2);
////        } catch (ParseException e) {
////        }
////        return newdate;
////    }
////    
////    public static void main(String[] args) {
////        testTimeline t = new testTimeline();
////        System.out.println(t.getDate());
////    }
////    
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}

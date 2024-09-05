//package com.ssg.w1.todo;
//
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "modify", urlPatterns = "/todo/modify")
//public class TodoModifyController extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//        throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/todo/modify.jsp");
//        rd.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//        throws ServletException, IOException {
//        resp.sendRedirect("list.jsp");
//    }
//
//}

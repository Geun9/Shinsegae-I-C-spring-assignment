package com.ssg.w1.todo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("입력 화면 register.jsp 으로 GET");
        RequestDispatcher rd = req.getRequestDispatcher("/todo/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println();
//        Todo todo = Todo.builder()
//            .title(req.getParameter("title"))
//            .dueDate(req.getParameter("dueDate"))
//            .build();
//
//        HttpSession session = req.getSession();
//        session.setAttribute("todo", todo);
//
//        resp.sendRedirect(req.getContextPath() + "/todo/list.jsp");
    }
}

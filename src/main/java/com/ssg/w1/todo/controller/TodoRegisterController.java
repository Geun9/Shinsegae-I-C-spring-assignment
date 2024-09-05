package com.ssg.w1.todo.controller;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    TodoDAO todoDAO = new TodoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("입력 화면 register.jsp 으로 GET");
        RequestDispatcher rd = req.getRequestDispatcher("/todo/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("입력을 처리하고 목록 페이지 이동");

            TodoVO vo = TodoVO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

            todoDAO.insert(vo);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.ssg.w1.todo.controller;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    TodoDAO todoDAO = new TodoDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("todo/read ........... 실행");

        // '/todo/read?id=12'
        try {
            Long id = Long.parseLong(req.getParameter("id"));

            TodoVO dto = todoDAO.selectOne(id);

            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

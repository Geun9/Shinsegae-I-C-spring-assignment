package com.ssg.w1.todo.controller;

import com.ssg.w1.todo.dao.TodoDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "remove", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    TodoDAO todoDAO = new TodoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("todo/remove POST ........... 실행");


            Long id = Long.parseLong(req.getParameter("id"));

            todoDAO.deleteOne(id);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

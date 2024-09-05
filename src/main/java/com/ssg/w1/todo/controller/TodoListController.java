package com.ssg.w1.todo.controller;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    TodoDAO todoDAO = new TodoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("/todo/list....call");
        try {
            List<TodoVO> dtoList = todoDAO.selectAllList();

            req.setAttribute("dtoList", dtoList);

            req.getRequestDispatcher("/todo/list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

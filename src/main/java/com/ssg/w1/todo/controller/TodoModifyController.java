package com.ssg.w1.todo.controller;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "modify", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    TodoDAO todoDAO = new TodoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("todo/modify GET ........... 실행");

        // '/todo/read?id=12'
        try {
            Long id = Long.parseLong(req.getParameter("id"));

            TodoVO dto = todoDAO.selectOne(id);

            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("todo/modify POST ........... 실행");

            System.out.println("check box: " + req.getParameter("finished"));

            TodoVO vo = TodoVO.builder()
                .id(Long.valueOf(req.getParameter("id")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .finished(Boolean.parseBoolean(req.getParameter("finished")))
                .build();

            todoDAO.updateOne(vo);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

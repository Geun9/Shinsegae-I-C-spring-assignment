package com.ssg.w1.todo.dao;

import static org.junit.jupiter.api.Assertions.*;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoDAOTest {

    TodoDAO dao = new TodoDAO();
    @Test
    void insert() throws Exception {
        TodoVO vo = TodoVO.builder()
            .title("Test Title")
            .dueDate(LocalDate.of(2024,9,05))
            .build();

        dao.insert(vo);
    }

    @Test
    void selectAllList() throws Exception{
        List<TodoVO> list = dao.selectAllList();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    void selectOne() throws Exception {
        TodoVO vo = dao.selectOne(1L);
        System.out.println(vo);
    }

    @Test
    void updateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
            .id(1L)
            .title("Update Test")
            .finished(true)
            .dueDate(LocalDate.now())
            .build();

        dao.updateOne(vo);
    }

    @Test
    void deleteOne() throws Exception {
        dao.deleteOne(4L);
    }
}
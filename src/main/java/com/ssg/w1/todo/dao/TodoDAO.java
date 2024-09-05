package com.ssg.w1.todo.dao;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.Cleanup;

public class TodoDAO {

    public void insert(TodoVO vo) throws Exception {
        String query = "INSERT INTO tbl_todo (title, dueDate, finished) VALUES (?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);

        psmt.setString(1, vo.getTitle());
        psmt.setDate(2, Date.valueOf(vo.getDueDate()));
        psmt.setBoolean(3, vo.isFinished());

        psmt.executeUpdate();
    }

    public List<TodoVO> selectAllList() throws Exception {
        List<TodoVO> list = new ArrayList<>();

        String query = "SELECT * FROM tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);
        @Cleanup ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            TodoVO vo = TodoVO.builder()
                .id(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();

            list.add(vo);
        }

        return list;
    }



    public TodoVO selectOne(Long id) throws Exception {
        TodoVO vo = null;
        String query = "SELECT * FROM tbl_todo WHERE tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);

        psmt.setLong(1, id);

        @Cleanup ResultSet rs = psmt.executeQuery();

        if (rs.next()) {
            vo = TodoVO.builder()
                .id(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();

        }

        return vo;
    }

    public void updateOne(TodoVO vo) throws Exception {
        String query = "UPDATE tbl_todo SET title = ?, dueDate = ?, finished = ? WHERE tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);
        System.out.println(vo);
        psmt.setString(1, vo.getTitle());
        psmt.setDate(2, Date.valueOf(vo.getDueDate()));
        psmt.setBoolean(3, vo.isFinished());
        psmt.setLong(4, vo.getId());

        psmt.executeUpdate();
    }


    public void deleteOne(Long id) throws Exception {
        String query = "DELETE FROM tbl_todo WHERE tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(query);

        psmt.setLong(1, id);
        psmt.executeUpdate();
    }
}

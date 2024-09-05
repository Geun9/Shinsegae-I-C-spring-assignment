package com.ssg.springex.jdbcex;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.Cleanup;

public class TodoDAO {

    String now = null;

    public String getTime() {

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            ResultSet rs = preparedStatement.executeQuery();
        ) {
            rs.next();
            now = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception {
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();

        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement("select now()");

        @Cleanup
        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        now = rs.getString(1);
        return now;
    }
}

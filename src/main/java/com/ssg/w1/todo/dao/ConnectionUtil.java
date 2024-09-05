package com.ssg.w1.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public enum ConnectionUtil {
    // ConnectionUtil 클래스는 하나의 객체를 만들어서 사용하는 방식이다.
    // HikariConfig를 이용해서 하나의 HikariDataSource를 구성한다.
    // 구성된 HikariDataSource는 getConnection()을 통해서 사용된다.
    // 외부에서는 ConnectionUtil.INSTANCE.getConnection()
    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?characterEncoding=UTF-8&serverTimezone=UTC");
        config.setUsername("webuser");
        config.setPassword("user1234");
        config.addDataSourceProperty("cachePrespStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }

}

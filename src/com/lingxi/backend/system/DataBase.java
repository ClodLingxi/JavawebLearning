package com.lingxi.backend.system;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;
import java.util.logging.Logger;

public class DataBase {
    protected static Connection connection;
    protected static final QueryRunner queryRunner = new QueryRunner();

    public static final Logger logger = Logger.getLogger("DataBase");
    private static Statement statement;

    public static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String DB_NAME = "learning";
    private static String DB_URL =
            "jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "123456";

    public static Boolean init(String url, String name, String password) {
        DB_URL = url;
        DB_USER = name;
        DB_PASSWORD = password;
        return init();
    }

    protected static Boolean init() {
        if(connection != null) return true;
        try {
            logger.info("Connecting to database...");

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

//            String sql = "use " + DB_NAME;
            String sql = "use learning";
            statement.execute(sql);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.warning("Database failed to initialize!");
            return false;
        }
        logger.info("Database successfully connected!");
        return true;
    }

    public static void close() throws SQLException {
        connection.close();
        statement.close();
    }

}

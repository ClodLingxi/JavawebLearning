package com.lingxi.backend;

import com.lingxi.dataform.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    private static final QueryRunner queryRunner = new QueryRunner();
    private static final Logger logger = Logger.getLogger("DataBase");

    public static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String DB_NAME = "learning";
    private static String DB_URL = "";
    private static String DB_USER = "";
    private static String DB_PASSWORD = "";

    public static Boolean init(String url, String name, String password) {
        DB_URL = url;
        DB_USER = name;
        DB_PASSWORD = password;
        return init();
    }

    private static Boolean init() {
        try {
            logger.info("Connecting to database...");

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

//            String sql = "use " + DB_NAME;
            String sql = "use learning";
            statement.execute(sql);

        } catch (ClassNotFoundException | SQLException e) {
            logger.warning("Database failed to initialize!");
            return false;
        }
        logger.info("Database successfully connected!");
        return true;
    }

    public static List<User> QueryUserData() {
        String sql = "select * from user";
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            return null;
        }
    }

    public static int UpdateUserData(User user) {
        String sql="update user set name=?,age=? where id=?";
        try {
            return queryRunner.update(connection, sql, user.getName(),user.getAge(),user.getId());
        } catch (SQLException e) {
            return -1;
        }
    }

    public static boolean DeleteUserData(User user) {
        String sql="delete from user where id=?";
        try {
            queryRunner.update(connection, sql, user.getId());
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    public static void close() throws SQLException {
        connection.close();
        statement.close();
    }

}

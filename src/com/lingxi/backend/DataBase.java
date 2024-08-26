package com.lingxi.backend;

import com.lingxi.dataform.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lingxi
 * @version 1.0
 */

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    private static final QueryRunner queryRunner = new QueryRunner();

    private static final ArrayList<Student> students = new ArrayList<>();

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "com.mysql.jdbc.Driver";
    static String DB_NAME = "com.mysql.jdbc.Driver";
    static String DB_PASSWORD = "com.mysql.jdbc.Driver";

    public DataBase(){}

    public DataBase(String url, String name, String password) {
        DB_URL = url;
        DB_NAME = name;
        DB_PASSWORD = password;
    }

    public static Boolean init(String url, String name, String password){
        DB_URL = url;
        DB_NAME = name;
        DB_PASSWORD = password;
        return init();
    }

    public static Boolean init(){
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");

            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        System.out.println("Database successfully connected!");
        return true;
    }

    public static List<Student> QueryStudentData(){
        String sql = "select * from student";
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            return null;
        }
    }

    public static void close() throws SQLException {
        connection.close();
        statement.close();
    }

}

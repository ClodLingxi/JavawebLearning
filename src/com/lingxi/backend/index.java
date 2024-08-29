package com.lingxi.backend;

import com.lingxi.backend.system.DataBase;
import com.lingxi.dataform.AdminData;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.SQLException;

@WebListener
public class index implements ServletContextListener {
    public static final String DB_URL =
            "jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "123456";

    public void contextInitialized(ServletContextEvent sce) {
        DataBase.logger.info("Initialize Server");

        DataBase.init(DB_URL, DB_NAME, DB_PASSWORD);
        AdminData.CleanLogin();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DataBase.logger.info("Close Server");
        try {
            DataBase.close();
        } catch (SQLException e) {
            DataBase.logger.warning("DataBase close failed!");
        }
    }
}

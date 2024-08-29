package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


public class AdminData extends DataBase {

    private static List<Admin> temp;

    public static int Validate(Passport passport){
        return Validate(passport.getName(), passport.getPassword());
    }

    public static int Validate(String name, String password) {
        if(!init()) return -1;

        String sql = "select * from admin where name=? and password=?";
        try {
            temp = queryRunner.query(connection, sql, new BeanListHandler<>(Admin.class), name, password);
            if (temp == null || temp.isEmpty()) return -1;
            else return temp.get(0).getId();
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to query admin");
            return -1;
        }
    }

    public static List<Admin> getOnlineList() {
        if(!init()) return null;

        String sql = "select * from admin where login=1";
        try {
            temp = queryRunner.query(connection, sql, new BeanListHandler<>(Admin.class));
            if (temp == null || temp.isEmpty()) return null;
            else return temp;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to get admin online list");
            return null;
        }
    }

    public static boolean isOnline(int id) {
        String sql = "select login from admin where id=?";
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), id);
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to load online admin");
            return false;
        }
    }

    public static boolean Login(int id) {
        String sql = "update admin set login=1 where id=?";
        try {
            System.out.println("test");
            return queryRunner.update(connection, sql, id) > 0;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to login");
            return false;
        }
    }

    public static void Exit(Passport passport){
        int id = Validate(passport);
        Exit(id);
    }

    public static void Exit(int id) {
        String sql = "update admin set login=0 where id=?";
        try {
            queryRunner.update(connection, sql, id);
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to exit");
        }
    }

    public static void CleanLogin(){
        String sql = "update admin set login=0;";
        try {
            queryRunner.update(connection, sql);
            DataBase.logger.info("Clean up login");
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to clean login");
        }
    }

}

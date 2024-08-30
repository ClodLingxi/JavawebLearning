package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


public class UserData extends DataBase {

    private static List<User> temp;

    public static List<User> getAdminList(Passport passport) {
        if (Validate(passport) > 0) {
            String sql = "select * from admin";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(User.class));
            } catch (SQLException e) {
                DataBase.logger.warning("Fail to query admin!");
                return null;
            }
        }
        return null;
    }

    public static int Validate(Passport passport){
        if(passport == null) return -1;
        return Validate(passport.getName(), passport.getPassword());
    }

    public static int Validate(String name, String password) {
        if(!init()) return -1;

        String sql = "select * from admin where name=? and password=?";
        try {
            temp = queryRunner.query(connection, sql, new BeanListHandler<>(User.class), name, password);
            if (temp == null || temp.isEmpty()) return -1;
            else return temp.get(0).getId();
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to query admin!");
            return -1;
        }
    }

    public static boolean Add(User user) {
        String sql = "insert into admin values(?,?,?,?,?,?)";
        try {
            return queryRunner.insert(connection, sql, new ScalarHandler<>(), user.toArray());
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to get add admin!");
            return false;
        }
    }

    public static boolean Delete(int id) {
        String sql = "delete from admin where id=?";
        try {
            int result = queryRunner.update(connection, sql, id);
            return result > 0;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to get delete admin!");
            return false;
        }
    }

    public static boolean Update(User user) {
        String sql = "update admin set name=?,password=?,realname=?,email=? " +
                "where id=?";
        try {
            int result = queryRunner.update(connection, sql, new ScalarHandler<>(), user.toArray(), user.getId());
            return result > 0;
        } catch (SQLException e){
            DataBase.logger.warning("Fail to get delete admin!");
            return false;
        }
    }

    public static List<User> getOnlineList() {
        if(!init()) return null;

        String sql = "select * from admin where login=1";
        try {
            temp = queryRunner.query(connection, sql, new BeanListHandler<>(User.class));
            if (temp == null || temp.isEmpty()) return null;
            else return temp;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to get admin online list!");
            return null;
        }
    }

    public static boolean isOnline(int id) {
        String sql = "select login from admin where id=?";
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), id);
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to load online admin!");
            return false;
        }
    }

    public static boolean Login(int id) {
        String sql = "update admin set login=1 where id=?";
        try {
            System.out.println("test");
            return queryRunner.update(connection, sql, id) > 0;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to login!");
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
            DataBase.logger.warning("Fail to exit!");
        }
    }

    public static void CleanLogin(){
        String sql = "update admin set login=0;";
        try {
            queryRunner.update(connection, sql);
            DataBase.logger.info("Clean up login");
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to clean login!");
        }
    }

}

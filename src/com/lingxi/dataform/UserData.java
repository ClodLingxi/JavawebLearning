package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


public class UserData extends DataBase {

    private static List<User> temp;

    public static List<User> getUserList(Passport passport) {
        if (Validate(passport) > 0) {
            String sql = "select * from admin";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(User.class));
            } catch (SQLException e) {
                logger.warning("Fail to query admin!");
                return null;
            }
        }
        return null;
    }

    public static User getUser(HttpServletRequest request) {
        String username = request.getParameter("userLogname");
        String password = request.getParameter("userPwd");
        String realName = request.getParameter("userRealname");
        String email = request.getParameter("userEmail");
        String role = request.getParameter("userRole");
        String state = request.getParameter("userState");

        return new User(username, password, realName,
                User.Role.values()[Integer.parseInt(role)], email, Integer.parseInt(state) > 0);
    }

    public static User getUser(Passport passport, int id) {
        if (Validate(passport) > 0) {
            String sql = "select * from admin where id = ?";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(User.class), id).get(0);
            } catch (SQLException e) {
                logger.warning("Fail to query admin!");
                return null;
            }
        }
        return null;
    }

    public static Boolean ValidateAdmin(Passport passport) {
        return true;
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
            DataBase.logger.warning("Fail to query user!");
            return -1;
        }
    }

    public static Boolean Add(User user) {
        String sql = "insert into admin(name,password,realName,role,email,enabled) values(?,?,?,?,?,?)";
        try {
            int result = queryRunner.update(connection, sql, user.toArray());
            return result > 0;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to add user!");
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

    public static boolean Update(User user, int id) {
        String sql = "update admin set name=?,password=?,realname=?,role=?,email=?,enabled=? " +
                "where id=?";
        try {
            System.out.println(user);
            int result = queryRunner.update(connection, sql, user.toArray(id));
            return result > 0;
        } catch (SQLException e){
            e.printStackTrace();
            DataBase.logger.warning("Fail to update user!");
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

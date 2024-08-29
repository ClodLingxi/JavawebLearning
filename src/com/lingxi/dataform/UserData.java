package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class UserData extends DataBase {

    public static List<User> QueryUserData() {
        if(!init()) return null;
        String sql = "select * from user";
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            return null;
        }
    }

    public static int UpdateUserData(User user) {
        if(!init()) return -1;
        String sql="update user set name=?,age=? where id=?";
        try {
            return queryRunner.update(connection, sql, user.getName(),user.getAge(),user.getId());
        } catch (SQLException e) {
            return -1;
        }
    }

    public static boolean DeleteUserData(User user) {
        if(!init()) return false;
        String sql="delete from user where id=?";
        try {
            queryRunner.update(connection, sql, user.getId());
            return true;
        } catch (SQLException e){
            return false;
        }
    }
}

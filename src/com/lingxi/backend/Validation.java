package com.lingxi.backend;

import com.lingxi.dataform.User;

import java.util.List;

public class Validation {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String DB_NAME = "root";
    static final String DB_PASSWORD = "123456";

    public static boolean connectDatabase() {
        return DataBase.init(DB_URL, DB_NAME, DB_PASSWORD);
    }

    public static boolean register(){

        List<User> userList = DataBase.QueryUserData();

        if(userList == null) return false;

        System.out.println(userList.size());



        return true;
    }
}

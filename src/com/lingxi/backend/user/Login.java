package com.lingxi.backend.user;

import com.lingxi.dataform.UserData;

public class Login {

    public enum LoginStatus {
        SUCCESS,
        FAIL,
        OCCUPIED,
    }

    public static LoginStatus login(String username, String password) {
        int id = UserData.Validate(username, password);
        if(id == -1) return LoginStatus.FAIL;
        if(UserData.isOnline(id) || !UserData.Login(id)) return LoginStatus.OCCUPIED;
        return LoginStatus.SUCCESS;
    }
}

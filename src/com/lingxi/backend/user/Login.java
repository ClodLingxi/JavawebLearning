package com.lingxi.backend.user;

import com.lingxi.dataform.AdminData;

public class Login {

    public enum LoginStatus {
        SUCCESS,
        FAIL,
        OCCUPIED,
    }

    public static LoginStatus login(String username, String password) {
        int id = AdminData.Validate(username, password);
        if(id == -1) return LoginStatus.FAIL;
        if(AdminData.isOnline(id) || !AdminData.Login(id)) return LoginStatus.OCCUPIED;
        return LoginStatus.SUCCESS;
    }
}

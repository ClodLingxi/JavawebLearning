package com.lingxi.backend.user;

import com.lingxi.dataform.Passport;
import com.lingxi.dataform.UserData;

public class Login {

    public enum LoginStatus {
        SUCCESS,
        FAIL,
        DISABLE,
        VERIFY_FAIL,
    }

    public static LoginStatus login(Passport passport) {
        int id = UserData.Validate(passport);

        if(id == -1) return LoginStatus.FAIL;
        if(!UserData.isEnable(id)) return LoginStatus.DISABLE;
        return LoginStatus.SUCCESS;
    }
}

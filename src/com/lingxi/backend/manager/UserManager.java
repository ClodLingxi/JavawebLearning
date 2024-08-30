package com.lingxi.backend.manager;

import com.lingxi.dataform.User;
import com.lingxi.dataform.UserData;
import com.lingxi.dataform.Passport;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UserManagerServlet")
public class UserManager extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Passport passport = (Passport) session.getAttribute("passport");
        if(UserData.Validate(passport) > 0){
            String type = req.getParameter("type");
            switch (type){
                case "add":
                    User user = (User) session.getAttribute("admin");
                    if(user != null){

                    }
            }
        }
    }
}

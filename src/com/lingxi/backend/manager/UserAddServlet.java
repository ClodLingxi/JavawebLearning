package com.lingxi.backend.manager;

import com.lingxi.dataform.Passport;
import com.lingxi.dataform.User;
import com.lingxi.dataform.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Passport passport = (Passport) session.getAttribute("passport");
        if(UserData.Validate(passport) > 0){
            User user = UserData.getUser(req);

            if (UserData.Add(user)){
                System.out.println("Success");
            } else System.out.println("Fail");
        }
    }
}

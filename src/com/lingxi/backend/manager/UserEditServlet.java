package com.lingxi.backend.manager;

import com.lingxi.dataform.User;
import com.lingxi.dataform.UserData;
import com.lingxi.dataform.Passport;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Passport passport = (Passport) session.getAttribute("passport");
        if(UserData.Validate(passport) > 0){
            User user = UserData.getUser(req);

            if (UserData.Update(user, Integer.parseInt(req.getParameter("id")))){
                System.out.println("Success");
            } else System.out.println("Fail");
        }
    }
}

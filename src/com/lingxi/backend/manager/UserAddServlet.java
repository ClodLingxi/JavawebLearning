package com.lingxi.backend.manager;

import com.lingxi.dataform.Passport;
import com.lingxi.dataform.User;
import com.lingxi.dataform.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.plaf.nimbus.State;


@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Passport passport = (Passport) session.getAttribute("passport");
        if(UserData.Validate(passport) > 0){
            String username = req.getParameter("userLogname");
            String password = req.getParameter("userPwd");
            String realName = req.getParameter("userRealname");
            String email = req.getParameter("userEmail");
            String role = req.getParameter("userRole");
            String state = req.getParameter("userState");

            User user = new User(username, password, realName,
                    User.Role.values()[Integer.parseInt(role)], email, Integer.parseInt(state) > 0);
            System.out.println(user);

            if (UserData.Add(user)){
                System.out.println("Success");
            } else System.out.println("Fail");
        }
    }
}

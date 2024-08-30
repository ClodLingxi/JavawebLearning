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
            User user;
            switch (type){
                case "add":
                    user = (User) session.getAttribute("userdata");
                    if(user != null){
                        if (UserData.Add(user)) System.out.println("Success");
                    }
                    System.out.println("Err");
                    break;
                case "update":
                    user = (User) session.getAttribute("userdata");
                    if(user != null){
                        if (UserData.Update(user)) System.out.println("Success");
                    }
                    System.out.println("Err");
                    break;
                case "delete":
                    int id = Integer.parseInt(req.getParameter("userid"));
                    if(UserData.Delete(id)) System.out.println("Success");
                    System.out.println("Err");
            }
        }
    }
}

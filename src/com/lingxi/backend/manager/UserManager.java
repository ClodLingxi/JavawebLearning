package com.lingxi.backend.manager;

import com.lingxi.dataform.AdminData;
import com.lingxi.dataform.Passport;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UserManager")
public class UserManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Passport passport = (Passport) session.getAttribute("passport");
        if(AdminData.Validate(passport) > 0){
            String id = req.getParameter("id");
            AdminData.Exit(Integer.parseInt(id));
        }
    }
}

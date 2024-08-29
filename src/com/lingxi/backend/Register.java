package com.lingxi.backend;

import com.lingxi.dataform.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || password == null) return;

        if(Validation.connectDatabase()){
            System.out.println("Valida success");
            List<User> userList = DataBase.QueryUserData();
            req.setAttribute("userList", userList);
            req.getRequestDispatcher(req.getContextPath() + "/table.jsp").forward(req, resp);
        }
    }
}

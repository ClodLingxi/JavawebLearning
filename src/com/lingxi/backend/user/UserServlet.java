package com.lingxi.backend.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("login")){
            String username = req.getParameter("userLogname");
            String password = req.getParameter("userPwd");
            if (username != null && password != null){
                boolean result = Login.login(username, password);
                if (result){

                }
            }
        }
        else if (req.getParameter("type").equals("logout")){

        }
    }
}

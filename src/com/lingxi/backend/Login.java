package com.lingxi.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Lingxi
 * @version 1.0
 */

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        req.setCharacterEncoding("UTF-8");

        if(username.equals("root") && password.equals("123456")){
            req.getRequestDispatcher(req.getContextPath() + "/login.html").forward(req, resp);
        }
        else {
            resp.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            resp.setHeader("Location", req.getContextPath() + "/register");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("GET name:%s pass:%s \n", username, password);
    }
}

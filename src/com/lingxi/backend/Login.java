package com.lingxi.backend;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Lingxi
 * @version 1.0
 */

public class Login extends HttpServlet {

//    protected void service(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException{
//
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
    }
}

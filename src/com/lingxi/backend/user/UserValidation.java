package com.lingxi.backend.user;

import com.lingxi.dataform.Passport;
import com.lingxi.dataform.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.lingxi.backend.user.Login.LoginStatus;

@WebServlet("/UserServlet")
public class UserValidation extends HttpServlet {
    final String LOGIN_PATH = "/";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String TARGET_PATH = "/manage/main.jsp";

        String TYPE = req.getParameter("type");

        if (TYPE.equals("login")) {
            String username = req.getParameter("userLogname");
            String password = req.getParameter("userPwd");
            String verifyCode = req.getParameter("verifyCode");

            String verifyCodeValue = (String)req.getSession().getAttribute("verifyCodeValue");

            HttpSession session = req.getSession();
//            if(!verifyCodeValue.equalsIgnoreCase(verifyCode)){
//                session.setAttribute("msg", "验证码错误");
//                resp.sendRedirect(LOGIN_PATH);
//                return;
//            }

            if (username != null && password != null){
                Passport passport = new Passport(User.Role.Admin, username, password);
                LoginStatus result = Login.login(passport);

                if (result == LoginStatus.SUCCESS){
                    session.setAttribute("passport", passport);
                    resp.sendRedirect(TARGET_PATH);
                }
                else if (result == LoginStatus.FAIL) {
                    session.setAttribute("msg", "登录失败");
                    resp.sendRedirect(LOGIN_PATH);
                }
                else if (result == LoginStatus.DISABLE){
                    session.setAttribute("msg", "账户被禁用");
                    resp.sendRedirect(LOGIN_PATH);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String TARGET_PATH = "/manage/main.jsp";

        String TYPE = req.getParameter("type");

        if (TYPE.equals("exit")){
            HttpSession session = req.getSession();
//            Passport passport = (Passport) req.getAttribute("passport");
//            if (passport != null){
//                UserData.Exit(passport);
//                session.invalidate();
//            }
            session.invalidate();
            resp.sendRedirect("/");
        }
    }
}

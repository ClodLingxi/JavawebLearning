package com.lingxi.backend.user;

import com.lingxi.dataform.UserData;
import com.lingxi.dataform.Passport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.lingxi.backend.user.Login.LoginStatus;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String LOGIN_PATH = "/login.jsp";
        final String TARGET_PATH = "/manage/main.jsp";

        String TYPE = req.getParameter("type");

        if (TYPE.equals("login")) {
            String username = req.getParameter("userLogname");
            String password = req.getParameter("userPwd");

            if (username != null && password != null){
                LoginStatus result = Login.login(username, password);
                HttpSession session = req.getSession();
                if (result == LoginStatus.SUCCESS){
                    session.setAttribute("passport",
                            new Passport(Passport.UserRole.admin, username, password));
                    resp.sendRedirect(TARGET_PATH);
                }
                else if (result == LoginStatus.FAIL) {
                    session.setAttribute("msg", "登录失败");
                    resp.sendRedirect(LOGIN_PATH);
                }
                else if (result == LoginStatus.OCCUPIED){
                    session.setAttribute("msg", "账户被占用");
                    resp.sendRedirect(LOGIN_PATH);
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String LOGIN_PATH = "/login.jsp";
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

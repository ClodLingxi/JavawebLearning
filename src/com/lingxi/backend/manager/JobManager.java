package com.lingxi.backend.manager;

import com.lingxi.dataform.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/JobServlet")
public class JobManager extends HttpServlet {
    private static int getId(HttpServletRequest req){
        String temp = req.getParameter("id");
        if(temp != null) return Integer.parseInt(temp);
        return 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = req.getParameter("type");
        if(type.equals("delete")){
            String id = req.getParameter("id");
            Passport passport = (Passport) req.getSession().getAttribute("passport");
            if(id != null && UserData.ValidateAdmin(passport)){
                JobData.deleteJob(new int[]{Integer.parseInt(id)});
                resp.sendRedirect("./manage/jobList.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
}

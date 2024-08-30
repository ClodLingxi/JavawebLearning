package com.lingxi.backend.manager;

import com.lingxi.dataform.CompanyData;
import com.lingxi.dataform.Passport;
import com.lingxi.dataform.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CompanyServlet")
public class CompanyManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = req.getParameter("type");
        if(type.equals("delete")){
            String id = req.getParameter("id");
            Passport passport = (Passport) req.getSession().getAttribute("passport");
            if(id != null && UserData.ValidateAdmin(passport)){
                CompanyData.deleteCompany(new int[]{Integer.parseInt(id)});
                resp.sendRedirect("./manage/companyList.jsp");
            }
        }
    }
}
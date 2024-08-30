package com.lingxi.backend.manager;

import com.lingxi.dataform.Company;
import com.lingxi.dataform.CompanyData;
import com.lingxi.dataform.Passport;
import com.lingxi.dataform.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CompanyServlet")
public class CompanyManager extends HttpServlet {

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
                CompanyData.deleteCompany(new int[]{Integer.parseInt(id)});
                resp.sendRedirect("./manage/companyList.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        Passport passport = (Passport) session.getAttribute("passport");
        if(UserData.ValidateAdmin(passport)){

            String type = req.getParameter("type");
            Company company = CompanyData.getCompany(req);

            if(type.equals("add")){
                if(CompanyData.addCompany(company)){
                    resp.sendRedirect("./manage/companyList.jsp");
                } else resp.sendRedirect(req.getRequestURI() + "?" + req.getQueryString());
            }
            else if(type.equals("update")){
                if(CompanyData.updateCompany(company, getId(req))){
                    resp.sendRedirect("./manage/companyList.jsp");
                } else resp.sendRedirect(req.getRequestURI() + "?" + req.getQueryString());
            }
        }
    }
}
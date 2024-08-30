<%@ page import="com.lingxi.dataform.UserData" %>
<%@ page import="com.lingxi.dataform.Passport" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Passport passport = (Passport) session.getAttribute("passport");
    if(passport != null){
        request.setAttribute("UserList", UserData.getUserList(passport));
    }
    else {

    }
%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>企业列表</title>
    <link href="../css/manageadmin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">用户列表</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="../images/t01.png"/></span><a href="userAdd.jsp">添加</a></li>
            <li class="click"><span><img src="../images/t02.png"/></span><a href="userAdd.jsp">修改</a></li>
            <li><span><img src="../images/t03.png"/></span><a href="userDelete.html">删除</a></li>
        </ul>
        <iframe src="userSearch.html" scrolling="no" frameborder="0" width="400" height="42"></iframe>
    </div>
    <table class="imgtable">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>用户登录名</th>
            <th>用户真实姓名</th>
            <th>用户Email</th>
            <th>用户角色</th>
            <th>用户状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <jstl:forEach items="${UserList}" var="user">
            <tr height="50px">
                <td><input name="" type="checkbox" value=""/></td>
                <td>${user.name} </td>
                <td>${user.realName} </td>
                <td>${user.email} </td>
                <td>${user.role.toString()} </td>
                <td>${user.enabled == true ? "启用" : "禁用"} </td>
                <td>
                    <a href="../UserManagerServlet" class="tablelink">修改</a> &nbsp;&nbsp;
                    <a href="../UserManagerServlet?type=delete&id=${user.id}" class="tablelink">删除</a>
                </td>
            </tr>
        </jstl:forEach>

        <tr height="50px">
            <td><input name="" type="checkbox" value=""/></td>
            <td>QST</td>
            <td>青软实训</td>
            <td>qst@test.com</td>
            <td>系统管理员</td>
            <td>启用</td>
            <td><a href="userAdd.jsp" class="tablelink">修改</a> &nbsp;&nbsp;
                <a href="#" class="tablelink"> 删除</a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>页，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;">首页</a></li>
            <li class="paginItem"><a href="javascript:;">上一页<span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">下一页<span class="pagenxt"></span></a></li>
            <li class="paginItem"><a href="javascript:;">尾页</a></li>
        </ul>
    </div>
</div>
</body>
</html>

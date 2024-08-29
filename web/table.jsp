<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Table - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
</head>
<body id="page-top">
<div id="wrapper">
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <div class="container-fluid"><h3 class="text-dark mb-4">Team</h3>
                <div class="card shadow">
                    <div class="card-header py-3"><p class="text-primary m-0 fw-bold">Employee Info</p></div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <div id="dataTable_length" class="dataTables_length"><label
                                        class="form-label">Show&nbsp;<select
                                        class="d-inline-block form-select form-select-sm">
                                    <option value="10" selected="">10</option>
                                    <option value="25">25</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                </select>&nbsp;</label></div>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-end dataTables_filter" id="dataTable_filter"><label
                                        class="form-label"><input type="search" class="form-control form-control-sm"
                                                                  aria-controls="dataTable"
                                                                  placeholder="Search"></label></div>
                            </div>
                        </div>
                        <div class="table-responsive table mt-2" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Age</th>
                                </tr>
                                </thead>
                                <tbody>

                                <%--@elvariable id="userList" type="java.util.List<com.lingxi.dataform.User>"--%>
                                <jstl:forEach items="${userList}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.name}</td>
                                        <td>${user.age}</td>
                                    </tr>
                                </jstl:forEach>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Age</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 align-self-center"><p id="dataTable_info" class="dataTables_info"
                                                                       role="status" aria-live="polite">Showing 1 to 10
                                of 27</p></div>
                            <div class="col-md-6">
                                <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                    <ul class="pagination">
                                        <li class="page-item disabled"><a class="page-link" aria-label="Previous"
                                                                          href="#"><span aria-hidden="true">«</span></a>
                                        </li>
                                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" aria-label="Next" href="#"><span
                                                aria-hidden="true">»</span></a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2024</span></div>
            </div>
        </footer>
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
</body>
</html>
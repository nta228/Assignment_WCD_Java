<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.Food" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.viewEntity.MessageView" %>
<%
    List<Food> foodList = (List<Food>) request.getAttribute("foodList");
    MessageView messageView = (MessageView) session.getAttribute("message");
    session.removeAttribute("message");
%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"/>
<body>
<div id="app">
    <div id="sidebar" class='active'>
        <jsp:include page="/admin/includes/main-sidebar.jsp"/>
    </div>
    <div id="main">
        <jsp:include page="/admin/includes/navbar.jsp"/>

        <div class="main-content container-fluid">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3>List Food</h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="<c:url value="/admin/foods/list"/>">Food Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page">List Food</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <section class="section">
                <div class="card">
                    <div class="card-header">
                        Food Datatable
                    </div>
                    <div class="card-body">
                        <table class="table card-table table-responsive table-responsive-large"
                               style="width:100%">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Thumbnails</th>
                                <th scope="col">Name</th>
                                <th scope="col">Category</th>
                                <th scope="col">Price</th>
                                <th scope="col">Status</th>
                                <th scope="col">Sale At</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${foodList}" var="food">
                                <tr>
                                    <td scope="row">${food.getId()}
                                    </td>
                                    <td>
                                        <img width="100" src="${food.getThumbnail()}"/>
                                    </td>
                                    <td>${food.getName()}
                                    </td>
                                    <td>${food.getCategory().getName()}
                                    </td>
                                    <td>
                                            <span class="badge badge-success">
                                                    ${food.getStatus()}
                                            </span>
                                    </td>
                                    <td>
                                        <div class="dropdown show d-inline-block widget-dropdown">
                                            <a class="dropdown-toggle icon-burger-mini" href="" role="button"
                                               id="dropdown-recent-order1" data-toggle="dropdown"
                                               aria-haspopup="true" aria-expanded="false" data-display="static"></a>
                                            <ul class="dropdown-menu dropdown-menu-right"
                                                aria-labelledby="dropdown-recent-order1">
                                                <li class="dropdown-item">
                                                    <a href="<c:url value="/admin/foods/update?id=${food.getId()}"/>">Edit</a>
                                                </li>
                                                <li class="dropdown-item">
                                                    <a href="#" data-toggle="modal"
                                                       data-target="#exampleModal${food.getId()}">Remove</a>

                                                </li>
                                            </ul>
                                        </div>
                                        <div class="modal fade" id="exampleModal${food.getId()}"
                                             tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                                             aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">
                                                            Confirmation</h5>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        Are you sure to delete food - ${food.getName()}
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-danger btn-pill"
                                                                data-dismiss="modal">Close
                                                        </button>
                                                        <a href="<c:url value="/admin/foods/delete?id=${food.getId()}"/>"
                                                           class="btn btn-primary btn-pill">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>
        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>
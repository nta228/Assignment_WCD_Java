<%@ page import="fpt.aptech.assignment_wcd.entity.myEnum.FormAction" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.myEnum.CategoryStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Category - Create"/>
</jsp:include>
<%
    FormAction formAction = (FormAction) request.getAttribute("formAction");
    String action = "/admin/categories/create";
    if (formAction == FormAction.UPDATE) {
        action = "/admin/categories/update";
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
    if (categoryList == null) {
        categoryList = new ArrayList<>();
    }
    Category category = (Category) request.getAttribute("category");
    if (category == null) {
        category = Category.CategoryBuilder.aCategory().build();
    }
%>
<body class="sidebar-fixed sidebar-dark header-light header-fixed" id="body">
<div class="mobile-sticky-body-overlay"></div>
<div class="wrapper">
    <jsp:include page="/admin/includes/main-sidebar.jsp"/>
    <div class="page-wrapper">
        <jsp:include page="/admin/includes/navbar.jsp"/>
        <div class="content-wrapper">
            <div class="content">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card card-default">
                            <div class="card-header card-header-border-bottom">
                                <h2>Create</h2>
                            </div>
                            <div class="card-body">
                                <form action="<%= action %>" method="post">
                                    <input type="hidden" name="id" value="<%= category.getId() %>" />
                                    <div class="form-row">
                                        <div class="col-md-12 mb-3">
                                            <label for="name">Category Name</label>
                                            <input type="text" class="form-control " id="name"
                                                   placeholder="First name" name="name" value="<%= category.getName() %>"
                                            >
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="parentId">Parent</label>
                                            <select class="form-control " name="parentId" id="parentId">
                                                <option value="0">Select Parent</option>
                                                <% for (Category item : categoryList) { %>
                                                <option value="<%= item.getId() %>" <% if (category.getParentId() == item.getId()) { %>
                                                        selected <% } %> >
                                                    <%= item.getName() %>
                                                </option>
                                                <% } %>
                                            </select>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="status">Status</label>
                                            <select name="status" class="form-control " id="status">
                                                <option value="0">Select Status</option>
                                                <% for (CategoryStatus categoryStatus : CategoryStatus.values()) { %>
                                                <option value="<%= categoryStatus.getValue() %>" <% if (category.getStatus().getValue() == categoryStatus.getValue()) { %>
                                                        selected <% } %> >
                                                    <%= categoryStatus.name() %>
                                                </option>
                                                <% } %>
                                            </select>
                                        </div>
                                    </div>
                                    <button class="btn btn-primary" type="submit">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>

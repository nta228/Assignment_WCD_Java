<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.Food" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.myEnum.FormAction" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.myEnum.FoodStatus" %>
<%
    FormAction formAction = (FormAction) request.getAttribute("formAction");
    String action = "/admin/foods/create";
    if (formAction == FormAction.UPDATE) {
        action = "/admin/foods/update";
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
    if (categoryList == null) {
        categoryList = new ArrayList<>();
    }
    Food food = (Food) request.getAttribute("food");
    if (food == null) {
        food = Food.FoodBuilder.aFood().build();
    }
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
                        <h3>Create
                        </h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="<c:url value="/admin/foods/list"/>">Food Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Create
                                </li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Food form</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <input type="hidden" name="id" value="<%= food.getId() %>"/>
                            <div class="form-row">
                                <div class="col-md-6 mb-3">
                                    <label for="name">Food Name</label>
                                    <input type="text" class="form-control " id="name"
                                           placeholder="Product Name" name="name"
                                           value="<%= food.getName() %>">
                                </div>
                                <div class="col-md-12 mb-3">
                                    <label for="price">Price</label>
                                    <input type="number" class="form-control " id="price"
                                           placeholder="Price" name="price" value="<%= food.getPrice() %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-12 mb-3">
                                    <label for="description">Description</label>
                                    <textarea class="form-control " id="description"
                                              placeholder="Description" name="description"
                                    ><%= food.getDescription() %></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="card card-default">
                <div class="card-header card-header-border-bottom">
                </div>
                <div class="card-body">
                    <form action="<%= action %>" method="post">
                        <input type="hidden" name="id" value="<%= food.getId() %>"/>
                        <div class="form-row">
                            <div class="col-md-12 mb-3">
                                <label for="thumbnail">Thumbnail</label>
                                <div>
                                    <img src="<%= food.getThumbnail() %>" id="upload-preview" width="300"
                                         class="img-responsive img-thumbnail rounded" alt=""/>
                                </div>
                                <div class="mt-2">
                                    <input type="hidden" multiple class="form-control " id="thumbnail"
                                           placeholder="Thumbnail" name="thumbnail" value="<%= food.getThumbnail() %>"
                                    >
                                    <button class="btn btn-info" type="button" id="upload_widget">
                                        Upload
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="categoryId">Category</label>
                                <select class="form-control " name="categoryId" id="categoryId">
                                    <option value="0">Select category</option>
                                    <% for (Category item : categoryList) { %>
                                    <option value="<%= item.getId() %>" <% if (food.getCategoryId() == item.getId()) { %>
                                            selected <% } %> >
                                        <%= item.getName() %>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="status">Status</label>
                                <select name="status" class="form-control " id="status">
                                    <% for (FoodStatus foodStatus : FoodStatus.values()) { %>
                                    <option value="<%= foodStatus.getValue() %>" <% if (food.getStatus().getValue() == foodStatus.getValue()) { %>
                                            selected <% } %> >
                                        <%= foodStatus.name() %>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="saleAt">Sale At</label>
                                <input type="date" class="form-control " id="saleAt"
                                       placeholder="Sale At" name="saleAt" value=""
                                >
                            </div>
                        </div>
                        <button class="btn btn-primary" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'tuananh228',
            uploadPreset: 'urfxtfwe'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                $('#preview-image').attr('src', result.info.secure_url);
                $('#hidden-thumbnails').val(result.info.secure_url);
            }
        }
    )
    document.getElementById("upload_widget").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
</body>
</html>
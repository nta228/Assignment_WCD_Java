<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/06/2022
  Time: 7:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.Food" %>
<%@ page import="fpt.aptech.assignment_wcd.entity.Category" %>
<%
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    if (categories == null) {
        categories = new ArrayList<>();
    }
    Food food = (Food) request.getAttribute("food");
    if (food == null) {
        food = Food.FoodBuilder.aFood().build();
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
                        <h3>Product Detail</h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/products/list">Food Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Food Detail</li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Food detail</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6 col-12">
                                    <div class="form-group">
                                        <label>Name: </label>
                                        <%=food.getName()%>
                                    </div>
                                </div>
                                <div class="col-md-6 col-12">
                                    <div class="form-group">
                                        <label>Price: </label>
                                        <%=food.getPrice()%>
                                    </div>
                                </div>
                                <div class="col-md-12 col-12">
                                    <div class="form-group">
                                        <label>Description: </label>
                                        <%=food.getDescription()%>
                                    </div>
                                </div>
                                <div class="col-md-12 col-12">
                                    <div class="form-group">
                                        <label>Thumbnail: </label>
                                        <img alt="" class="img-thumbnail img-rounded" src="<%=food.getThumbnail()%>">
                                    </div>
                                </div>
                                <div class="col-md-6 col-12">
                                    <div class="form-group">
                                        <label>Category: </label>
                                        <%=food.getCategoryId()%>
                                    </div>
                                </div>
                                <div class="col-md-6 col-12">
                                    <div class="form-group">
                                        <label>Status: </label>
                                        <%=food.getStatus().name()%>
                                    </div>
                                </div>
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
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script type="text/javascript">
    const myWidget = cloudinary.createUploadWidget({
            cloudName: 'tuananh228',
            uploadPreset: 'urfxtfwe'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                $('#preview-image').attr('src', result.info.secure_url);
                $('#hidden-thumbnails').val(result.info.secure_url);
            }
        }
    );
    document.getElementById("upload_widget").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
</body>
</html>
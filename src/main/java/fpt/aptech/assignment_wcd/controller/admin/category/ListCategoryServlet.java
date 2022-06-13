package fpt.aptech.assignment_wcd.controller.admin.category;

import fpt.aptech.assignment_wcd.entity.Category;
import fpt.aptech.assignment_wcd.model.MySqlCategoryModel;
import fpt.aptech.assignment_wcd.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCategoryServlet", urlPatterns = "/admin/categories")
public class ListCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=UTF-8");
        List<Category> categoryList = categoryModel.findAll();
        if(categoryList == null) {
            categoryList = new ArrayList<>();
        }
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/category/list.jsp").forward(req, res);
    }
}

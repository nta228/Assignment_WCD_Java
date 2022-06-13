package fpt.aptech.assignment_wcd.controller.admin.category;

import fpt.aptech.assignment_wcd.entity.Category;
import fpt.aptech.assignment_wcd.entity.myEnum.CategoryStatus;
import fpt.aptech.assignment_wcd.entity.myEnum.MessageType;
import fpt.aptech.assignment_wcd.entity.viewEntity.MessageView;
import fpt.aptech.assignment_wcd.model.MySqlCategoryModel;
import fpt.aptech.assignment_wcd.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", urlPatterns = "/admin/categories/delete")
public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getParameter("id") == null) {
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, res);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryModel.findById(id);
        if(category == null) {
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, res);
            return;
        }
        MessageView messageView = new MessageView();
        HttpSession session = req.getSession();
        category.setStatus(CategoryStatus.DELETED);
        if(categoryModel.update(id, category)) {
           messageView.setMessageType(MessageType.SUCCESS);
        }else {
            messageView.setMessageType(MessageType.ERROR);
        }
        session.setAttribute("message", messageView);
        res.sendRedirect("/admin/categories");
    }
}

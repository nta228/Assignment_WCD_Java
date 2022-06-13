package fpt.aptech.assignment_wcd.controller.admin.food;

import fpt.aptech.assignment_wcd.entity.Category;
import fpt.aptech.assignment_wcd.entity.Food;
import fpt.aptech.assignment_wcd.entity.myEnum.FoodStatus;
import fpt.aptech.assignment_wcd.entity.myEnum.FormAction;
import fpt.aptech.assignment_wcd.entity.myEnum.MessageType;
import fpt.aptech.assignment_wcd.entity.viewEntity.MessageView;
import fpt.aptech.assignment_wcd.model.MySqlCategoryModel;
import fpt.aptech.assignment_wcd.model.MySqlFoodModel;
import fpt.aptech.assignment_wcd.model.CategoryModel;
import fpt.aptech.assignment_wcd.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "CreateFoodServlet", urlPatterns = "/admin/foods/create")
public class CreateFoodServlet extends HttpServlet {
    private FoodModel foodModel;
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("formAction", FormAction.CREATE);
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/foods/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        String code = req.getParameter("code");
        String description = req.getParameter("description");
        double price = 0;
        if(req.getParameter("price") != null) {
            price = Double.parseDouble(req.getParameter("price"));
        }
        FoodStatus status = FoodStatus.of(Integer.parseInt(req.getParameter("status")));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Food food = Food.FoodBuilder.aFood()
                .withName(name)
                .withThumbnail(thumbnail)
                .withPrice(price)
                .withStatus(status)
                .withCategoryId(categoryId)
                .withDescription(description)
                .build();
        HttpSession session = req.getSession();
        MessageView messageView = new MessageView();
        try {
            if(food.isValid()) {
                if(foodModel.create(food)) {
                    messageView.setMessageType(MessageType.SUCCESS);
                }else {
                    throw new Exception();
                }
            }else {
                List<Category> categoryList = categoryModel.findAll();
                req.setAttribute("formAction", FormAction.CREATE);
                req.setAttribute("categoryList", categoryList);
                req.setAttribute("food", food);
                req.setAttribute("errors", food.getErrors());
                req.getRequestDispatcher("/admin/foods/form.jsp").forward(req, resp);
                return;
            }
        }catch (Exception e) {
            messageView.setMessageType(MessageType.ERROR);
        }
        session.setAttribute("message", messageView);
        resp.sendRedirect("/admin/foods");
    }
}

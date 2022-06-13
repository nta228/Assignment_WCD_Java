package fpt.aptech.assignment_wcd.controller.admin.food;

import fpt.aptech.assignment_wcd.entity.Food;
import fpt.aptech.assignment_wcd.model.MySqlFoodModel;
import fpt.aptech.assignment_wcd.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListFoodServlet", urlPatterns = "/admin/foods")
public class ListFoodServlet extends HttpServlet {
    private FoodModel foodModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        List<Food> foodList = foodModel.findAll();
        req.setAttribute("foodList", foodList);
        req.getRequestDispatcher("/admin/foods/list.jsp").forward(req, resp);
    }
}

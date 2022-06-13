package fpt.aptech.assignment_wcd.controller.admin.food;

import fpt.aptech.assignment_wcd.entity.Food;
import fpt.aptech.assignment_wcd.entity.myEnum.FoodStatus;
import fpt.aptech.assignment_wcd.entity.myEnum.MessageType;
import fpt.aptech.assignment_wcd.entity.viewEntity.MessageView;
import fpt.aptech.assignment_wcd.model.MySqlFoodModel;
import fpt.aptech.assignment_wcd.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteFoodServlet", urlPatterns = "/admin/foods/delete")
public class DeleteFoodServlet extends HttpServlet {
    private FoodModel foodModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null || req.getParameter("id").length() == 0) {
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Food food = foodModel.findById(id);
        if( food == null) {
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
            return;
        }
        MessageView messageView = new MessageView();
        HttpSession session = req.getSession();
        food.setStatus(FoodStatus.DELETED);
        try {
            if(foodModel.update(id, food)) {
                messageView.setMessageType(MessageType.SUCCESS);
            }else {
               throw new Exception();
            }
        }catch (Exception e) {
            messageView.setMessageType(MessageType.ERROR);
        }
        session.setAttribute("message", messageView);
        resp.sendRedirect("/admin/foods");
    }
}

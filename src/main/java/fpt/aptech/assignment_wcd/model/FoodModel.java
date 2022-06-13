package fpt.aptech.assignment_wcd.model;

import fpt.aptech.assignment_wcd.entity.Food;
import java.util.List;

public interface FoodModel {
    boolean create(Food obj);
    boolean update(int id, Food obj);
    boolean delete(int id);
    Food findById(int id);
    List<Food> findAll();
}

package com.system.recipe_app.Service;

import com.system.recipe_app.entity.Food;
import com.system.recipe_app.pojo.FoodPojo;

import java.io.IOException;
import java.util.List;

public interface FoodService {
    List<Food> fetchAll();

    String saveFood (FoodPojo foodPojo) throws IOException;

    Food fetchById(Integer id);

    void deleteById(Integer id);

    List<Food> getAllFood();
}

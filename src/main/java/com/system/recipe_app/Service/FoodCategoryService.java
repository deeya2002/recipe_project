package com.system.recipe_app.Service;
import com.system.recipe_app.entity.FoodCategory;
import com.system.recipe_app.pojo.FoodCategoryPojo;

import java.util.List;

public interface FoodCategoryService {

    List<FoodCategory> fetchAll();

    String saveUser (FoodCategoryPojo foodCategoryPojo);

    FoodCategory fetchById(Integer id);

    void deleteById(Integer id);
}

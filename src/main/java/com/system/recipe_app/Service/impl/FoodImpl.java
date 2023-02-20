package com.system.recipe_app.Service.impl;

import com.system.recipe_app.Service.FoodService;
import com.system.recipe_app.entity.Food;
import com.system.recipe_app.entity.FoodCategory;
import com.system.recipe_app.pojo.FoodPojo;
import com.system.recipe_app.repo.FoodCategoryRepo;
import com.system.recipe_app.repo.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodImpl implements FoodService {
    @Autowired
    private final FoodRepo foodRepo;
    private final FoodCategoryRepo foodCategoryRepo;
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/rescources/static/images/";


    @Override
    public List<Food> fetchAll() {
        return foodRepo.findAll();
    }

    @Override
    public String saveFood(FoodPojo foodPojo) throws IOException {
        Food food = new Food();
        food.setId(foodPojo.getId());
        food.setFood_name(foodPojo.getFood_name());
        food.setDescription(foodPojo.getDescription());
        food.setIngredients(foodPojo.getIngredients());
        food.setDuration(foodPojo.getDuration());
        FoodCategory foodCategory= foodCategoryRepo.findById(foodPojo.getFoodCategory()).orElseThrow(null);
        food.setFoodCategory(foodCategory);
        food.setImage(foodPojo.getImage());
        foodRepo.save(food);
        return "Created";
    }

    @Override
    public Food fetchById(Integer id) {
        return foodRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        foodRepo.deleteById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return  foodRepo.findAll();
    }


}

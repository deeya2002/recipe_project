package com.system.recipe_app.Service.impl;

import com.system.recipe_app.Service.FoodCategoryService;
import com.system.recipe_app.entity.FoodCategory;
import com.system.recipe_app.pojo.FoodCategoryPojo;
import com.system.recipe_app.repo.FoodCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoodCategoryImpl implements FoodCategoryService {
    @Autowired
    private final FoodCategoryRepo foodCategoryRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("admin.dir") + "/category";


    @Override
    public List<FoodCategory> fetchAll() {
        return foodCategoryRepo.findAll();
    }

    @Override
    public String saveUser(FoodCategoryPojo foodCategoryPojo) {
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(foodCategoryPojo.getId());
        foodCategory.setName(foodCategoryPojo.getName());
        foodCategory.setDescription(foodCategoryPojo.getDescription());
        foodCategory.setImage(foodCategoryPojo.getImage());
        foodCategoryRepo.save(foodCategory);
        return "Created";
    }

    @Override
    public FoodCategory fetchById(Integer id) {
        return foodCategoryRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        foodCategoryRepo.deleteById(id);
    }

}

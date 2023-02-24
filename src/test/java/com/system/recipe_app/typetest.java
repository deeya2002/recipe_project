package com.system.recipe_app;

import com.system.recipe_app.entity.FoodCategory;
import com.system.recipe_app.repo.FoodCategoryRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class typetest {
    @Autowired
    private FoodCategoryRepo foodCategoryRepo;
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTesting(){
        FoodCategory foodCategory= FoodCategory.builder()
                .name("test category")
                .description("test description")
                .image("test url")
                .build();
        foodCategoryRepo.save(foodCategory);
        Assertions.assertThat(foodCategory.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void gettinguserTest(){
        FoodCategory foodCategoryGet= foodCategoryRepo.findById(1).get();
        Assertions.assertThat(foodCategoryGet.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void getListOfUserTest(){
        List<FoodCategory> foodcategoryList = foodCategoryRepo.findAll();
        Assertions.assertThat(foodcategoryList.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){
        FoodCategory foodCategory = foodCategoryRepo.findById(1).get();
        foodCategory.setName("food name");
        FoodCategory categoryUpdated =  foodCategoryRepo.save(foodCategory);
        Assertions.assertThat(categoryUpdated.getName()).isEqualTo("food name");
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        FoodCategory foodCategory = foodCategoryRepo.findById(1).get();
        foodCategoryRepo.delete(foodCategory);
        FoodCategory category1 = null;
        Optional<FoodCategory> categoryByName = foodCategoryRepo.findCategoryByName("food name");
        if(categoryByName.isPresent()){
            category1 = categoryByName.get();
        }
        Assertions.assertThat(category1).isNull();
    }
}
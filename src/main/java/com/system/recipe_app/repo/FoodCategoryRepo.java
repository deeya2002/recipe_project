package com.system.recipe_app.repo;


import com.system.recipe_app.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepo extends JpaRepository<FoodCategory,Integer> {


}

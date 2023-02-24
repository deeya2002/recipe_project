package com.system.recipe_app.repo;


import com.system.recipe_app.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodCategoryRepo extends JpaRepository<FoodCategory,Integer> {


    Optional<FoodCategory> findCategoryByName(String name);
}

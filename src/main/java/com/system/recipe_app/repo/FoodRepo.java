package com.system.recipe_app.repo;

import com.system.recipe_app.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}

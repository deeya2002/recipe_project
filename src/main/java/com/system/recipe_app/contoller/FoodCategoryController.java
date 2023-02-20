package com.system.recipe_app.contoller;


import com.system.recipe_app.Service.FoodCategoryService;
import com.system.recipe_app.entity.FoodCategory;
import com.system.recipe_app.pojo.FoodCategoryPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/foodcatego")
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;

    @GetMapping
//    public String adminHome(){
//        return "admin/sidebar";
//    }
//    @GetMapping("/categories")
    public String getCategoriesPage(Model model){
        List<FoodCategory> foodcategory= foodCategoryService.fetchAll();
        model.addAttribute("foodcategoryList",foodcategory);
        return "/admin/viewcategory";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("food_category",new FoodCategoryPojo());
        return "/admin/addfoodcate";
    }

    @GetMapping("/list")
    public String getCategoriesList(Model model){
        List<FoodCategory> foodcategory= foodCategoryService.fetchAll();
        model.addAttribute("foodcategoryList",foodcategory);
        return "/admin/viewcategory";
    }
    @PostMapping("/add")
    public String saveUser (@Valid FoodCategoryPojo foodCategoryPojo){
        foodCategoryService.saveUser(foodCategoryPojo);
        return "redirect:/foodcatego";
    }

    @GetMapping("/edit/{id}")
    public String getEditAction(@PathVariable("id") Integer id, Model model){
        FoodCategory foodCategory= foodCategoryService.fetchById(id);
        model.addAttribute("food_category",new FoodCategoryPojo(foodCategory));
        return "/admin/addfoodcate";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteAction(@PathVariable("id") Integer id,Model model){
        foodCategoryService.deleteById(id);
        return "redirect:/foodcatego";
    }

}
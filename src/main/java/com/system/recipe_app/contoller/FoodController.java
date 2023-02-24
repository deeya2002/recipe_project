package com.system.recipe_app.contoller;

import com.system.recipe_app.Service.FoodCategoryService;
import com.system.recipe_app.Service.FoodService;
import com.system.recipe_app.Service.UserService;
import com.system.recipe_app.entity.Food;
import com.system.recipe_app.entity.User;
import com.system.recipe_app.pojo.FoodPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;
    private final FoodCategoryService foodCategoryService;
    private  final UserService userService;

    @GetMapping
//    public String plantHome(){
//        return "admin/plants";
//    }
//
//    @GetMapping("/foods")
    public String getFoodPage(Model model){
        model.addAttribute("foodList", foodService.getAllFood());
        model.addAttribute("foodcategoryList", foodCategoryService.fetchAll());
        return "/admin/viewrecipe";
    }

    @GetMapping("/create")
    public String CreatePlant(Model model){
        model.addAttribute("food",new FoodPojo());
        model.addAttribute("foodcategoryList", foodCategoryService.fetchAll());
        return "/admin/addfood";
    }

    @PostMapping("/add")
    public String savePlant (@Valid FoodPojo foodPojo) throws IOException {
        foodService.saveFood(foodPojo);
        return "redirect:/foods";
    }

    @GetMapping("/edit/{id}")
    public String getEditAction(@PathVariable("id") Integer id, Model model){
        Food food= foodService.fetchById(id);
        model.addAttribute("food",new FoodPojo(food));
        return "/admin/addfood";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteAction(@PathVariable("id") Integer id,Model model){
        foodService.deleteById(id);
        return "redirect:/foods";
    }

    @GetMapping("/userlist")
    public String getUserList(Model model){
        List<User> users=userService.fetchAll();
        model.addAttribute("userList",users);
        return "admin/userview";
    }

}

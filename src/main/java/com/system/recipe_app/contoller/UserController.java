
package com.system.recipe_app.contoller;

import com.system.recipe_app.Service.UserService;
import com.system.recipe_app.entity.User;
import com.system.recipe_app.pojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    public String getIndexPage(){

        return "user/index";
    }
    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("user",new UserPojo());
        return "user/create";
    }
    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new UserPojo());
        return "user/register";
    }
    @GetMapping("/list")
    public String getUserList(Model model){
        List<User> users = userService.fetchAll();
        model.addAttribute("userList",users);

        return "user/index";
    }
    @PostMapping("/save")
    public String saveUser (@Valid  UserPojo userPojo, BindingResult bindingResult){
    userService.saveUser(userPojo);
    return "redirect: /user/list";
    }

@GetMapping("/edit/{id}")
    public String getEditAction(@PathVariable("id")Integer id,Model model){
    User user = userService.fetchById(id);
    model.addAttribute("user",new UserPojo(user));
    return "/user/create";
}

    @GetMapping("/delete/{id}")
    public String getDeleteAction(@PathVariable("id")Integer id,Model model){
    userService.deleteById(id);
        return "redirect: /user/list";
    }


//    public Map<String, String> validateRequest(BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            return null;
//        }
//        Map<String, String> errors = new HashMap<>();
//        bindingResult.getAllErrors().forEach(error -> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return errors;
//
//    }
//
//    public String getImageBase64(String fileName) {
//        String filePath = System.getProperty("user.dir") + "/canteen_mgmt/";
//        File file = new File(filePath + fileName);
//        byte[] bytes = new byte[0];
//        try {
//            bytes = Files.readAllBytes(file.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        String base64 = Base64.getEncoder().encodeToString(bytes);
//        return base64;
//    }

}

//
//package com.system.recipe_app.contoller;
//import com.system.recipe_app.Service.UserService;
//import com.system.recipe_app.entity.User;
//import com.system.recipe_app.pojo.UserPojo;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class UserController {
//    private final UserService userService;
//
//
//    @GetMapping
//    public String getPage() {
//        return "Hello_page";
//    }
//
//
//    @GetMapping("/index")
//    public String getIndexPage(){
//        return "user/index";
//    }
//
//    @GetMapping("/create")
//    public String getCreatePage(Model model){
//        model.addAttribute("user",new UserPojo());
//        return "user/create";
//    }
//
//    @GetMapping("/register")
//    public String getRegister(Model model) {
////        model.addAttribute("user", new UserPojo());
//        return "/register";
//    }
//
//    @GetMapping("/list")
//    public String getUserList(Model model){
//        List<User> users=userService.fetchAll();
//        model.addAttribute("userList",users);
//        return "user/index";
//    }
//    @PostMapping("/save")
//    public String saveUser (@Valid UserPojo userPojo, HttpServletResponse httpServletResponse) {
//        httpServletResponse.addHeader("Referrer-Policy", "strict-origin-when-cross-origin");
//        System.out.println("welcome");
//        userService.saveUser(userPojo);
//        return "redirect:/user/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String getEditAction(@PathVariable("id") Integer id,Model model){
//        User user= userService.fetchById(id);
//        model.addAttribute("user",new UserPojo(user));
//        return "/user/create";
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public String getDeleteAction(@PathVariable("id") Integer id,Model model){
//        userService.deleteById(id);
//        return "redirect:/user/list";
//    }
//
//}

//package com.system.recipe_app.Service.impl;
//import com.system.recipe_app.Service.UserService;
//import com.system.recipe_app.config.PasswordEncoderUtil;
//import com.system.recipe_app.entity.User;
//import com.system.recipe_app.pojo.UserPojo;
//import com.system.recipe_app.repo.EmailCredRepo;
//import com.system.recipe_app.repo.UserRepo;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import jakarta.mail.internet.MimeMessage;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final JavaMailSender getJavaMailSender;
//    private final EmailCredRepo emailCredRepo;
//    private final ThreadPoolTaskExecutor taskExecutor;
//
//    @Autowired
//    @Qualifier("emailConfigBean")
//    private Configuration emailConfig;
//
//
//    private final UserRepo userRepo;
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/canteen_mgmt";
//
//    @Override
//    public UserPojo save(UserPojo userPojo) throws IOException {
//        User user;
//        if (userPojo.getId() != null) {
//            user = userRepo.findById(userPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
//        } else {
//            user = new User();
//        }
//        user.setEmail(userPojo.getEmail());
//        user.setFullName(userPojo.getFullname());
//        user.setMobileNo(userPojo.getMobile_no());
//        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
//
////        if(userPojo.getImage()!=null){
////            StringBuilder fileNames = new StringBuilder();
////            System.out.println(UPLOAD_DIRECTORY);
////            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());
////            fileNames.append(userPojo.getImage().getOriginalFilename());
////            Files.write(fileNameAndPath, userPojo.getImage().getBytes());
////
////            user.setImage(userPojo.getImage().getOriginalFilename());
////        }
//
//        userRepo.save(user);
//        return new UserPojo(user);
//    }
//
//    public List<User> fetchAll() {
//        return userRepo.findAll();
//    }
//
//    @Override
//    public String saveUser(UserPojo userPojo) {
//        return null;
//    }
//
//    public User fetchById(Integer id) {
//        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
//    }
//
//    public void deleteById(Integer id){
//        userRepo.deleteById(id);
//    }
//
//    @Override
//    public void sendEmail() {
//        try {
//            Map<String, String> model = new HashMap<>();
//
//            MimeMessage message = getJavaMailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
//
//            Template template = emailConfig.getTemplate("emailTemp.ftl");
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
//
//            mimeMessageHelper.setTo("sendTo@yopmail.com");
//            mimeMessageHelper.setText(html, true);
//            mimeMessageHelper.setSubject("Registration");
//            mimeMessageHelper.setFrom("infodev.angular@gmail.com");
//
//            taskExecutor.execute(new Thread() {
//                public void run() {
//                    getJavaMailSender.send(message);
//                }
//            });
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//}


package com.system.recipe_app.Service.impl;

import com.system.recipe_app.Service.UserService;
import com.system.recipe_app.config.PasswordEncoderUtil;
import com.system.recipe_app.entity.User;
import com.system.recipe_app.pojo.UserPojo;
import com.system.recipe_app.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public UserPojo save(UserPojo userPojo) throws IOException {
        return null;
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public String saveUser(UserPojo userPojo) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setId(userPojo.getId());
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
//        System.out.println("password "+userPojo.getPassword()+ "new password "+passwordEncoder.encode(userPojo.getPassword()));
//        user.setPassword(passwordEncoder.encode(userPojo.getPassword()));
        userRepo.save(user);
        return "Created";

    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }



}

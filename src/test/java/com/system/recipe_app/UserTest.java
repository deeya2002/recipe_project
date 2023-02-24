package com.system.recipe_app;


import com.system.recipe_app.entity.User;
import com.system.recipe_app.repo.UserRepo;
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
public class UserTest {
    @Autowired
    private UserRepo userRepo;
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTesting(){
        User user= User.builder()
                .fullname("dia dang")
                .email("icewater@gmail.com")
                .mobileNo("985641230")
                .password("ice@test")
                .build();
        userRepo.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void gettinguserTest(){
        User userGet=userRepo.findById(1).get();
        Assertions.assertThat(userGet.getEmail()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void getListOfUserTest(){
        List<User> userList = userRepo.findAll();
        Assertions.assertThat(userList.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){
        User user = userRepo.findByEmail("icewater@gmail.com").get();
        user.setFullname("aayus pradhan");
        User userUpdated =  userRepo.save(user);
        Assertions.assertThat(userUpdated.getFullname()).isEqualTo("aayus pradhan");
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = userRepo.findById(1).get();
        userRepo.delete(user);
        User user1 = null;
        Optional<User> opUser = userRepo.findByEmail("icewater@gmail.com");
        if(opUser.isPresent()){
            user1 = opUser.get();
        }
        Assertions.assertThat(user1).isNull();
    }
}
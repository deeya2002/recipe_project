package com.system.recipe_app.Service;

import com.system.recipe_app.entity.User;
import com.system.recipe_app.pojo.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserPojo save(UserPojo userPojo) throws IOException;

    List<User> fetchAll();

    String saveUser(UserPojo userPojo);

    User fetchById(Integer id);

    void deleteById(Integer id);
}

package com.system.recipe_app.repo;


import com.system.recipe_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

        @Query(value = "select * from users where email=?1", nativeQuery = true)
        Optional<User> findByEmail(String email);

//        @Query(value = "select * from users where username=?1", nativeQuery = true)
//        User findUserByUsername(String username);
//
//        Optional<User> findUserByFullName(String fullname);

}

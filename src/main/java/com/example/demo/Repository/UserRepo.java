package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    //User findByUsername(String username);
    List<User> findAll();

    @Modifying
    @Query(value = "insert into users (username,password,enabled) VALUES (:username,:password,:enabled);", nativeQuery = true)
    @Transactional
    void logUser(@Param("username") String username, @Param("password") String password,@Param("enabled") boolean enabled);

    @Modifying
    @Query(value = "insert into authorities values (:username,:role);", nativeQuery = true)
    @Transactional
    void logPermission(@Param("username") String username,@Param("role")String role);
}


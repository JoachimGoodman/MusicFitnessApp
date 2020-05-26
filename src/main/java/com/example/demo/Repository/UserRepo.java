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
//Repository til Brugere. Her bruges to metoder til at lave nye brugere i databasen
// og give dem en autoritetsrolle i en anden tabel.

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    List<User> findAll();

    User findByUsername(String username);

    @Modifying
    @Query(value = "insert into users (username,password,enabled, firstname, lastname, email) VALUES (:username,:password,:enabled, :firstname, :lastname, :email);", nativeQuery = true)
    @Transactional
    void logUser(@Param("username") String username, @Param("password") String password,@Param("enabled") boolean enabled, @Param("firstname") String firstname, @Param("lastname") String lastname, @Param("email") String email);

    @Modifying
    @Query(value = "insert into authorities values (:username,:role);", nativeQuery = true)
    @Transactional
    void logPermission(@Param("username") String username,@Param("role")String role);

    @Query(
            value = "SELECT * FROM  u WHERE u.status = 1",
            nativeQuery = true)
    List<User> findAllActiveUsersNative();
}


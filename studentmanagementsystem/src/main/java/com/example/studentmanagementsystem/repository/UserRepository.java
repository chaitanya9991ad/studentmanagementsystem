package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.com.example.studentmanagementsystem.api.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
}
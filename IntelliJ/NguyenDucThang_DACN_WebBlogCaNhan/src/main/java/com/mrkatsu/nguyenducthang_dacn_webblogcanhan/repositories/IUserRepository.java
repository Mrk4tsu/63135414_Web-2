package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories;


import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}

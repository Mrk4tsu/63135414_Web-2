package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces;


import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.User;

public interface IUserService {
    Boolean save(User user);

    User findByUsername(String username);

    User findById(Long id);
}

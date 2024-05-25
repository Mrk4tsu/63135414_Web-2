package com.mrkatsu.quanlybaivietblog.admin.services.interfaces;

import com.mrkatsu.quanlybaivietblog.admin.models.User;

public interface IUserService {
    void save(User user);

    User findByUsername(String username);
}

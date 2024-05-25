package com.mrkatsu.quanlybaivietblog.admin.services;

import com.mrkatsu.quanlybaivietblog.admin.models.User;
import com.mrkatsu.quanlybaivietblog.admin.repositories.IUserRepository;
import com.mrkatsu.quanlybaivietblog.admin.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired private IUserRepository repository;
    @Override
    public void save(User user) {

    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}

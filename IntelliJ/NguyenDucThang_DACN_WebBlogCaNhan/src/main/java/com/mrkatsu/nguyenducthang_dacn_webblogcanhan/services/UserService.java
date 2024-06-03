package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.User;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories.IUserRepository;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired private IUserRepository repository;
    @Override
    public Boolean save(User user) {
        try {
            this.repository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
    public User findById(Long id) {
        return this.repository.findById(id).get();
    }
}

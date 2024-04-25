package org.example.nguyenducthang_dacn_webblogcanhan.services;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private IUserRepository userRepository;
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }
    public void save(User user) {
        userRepository.save(user);
    }
}

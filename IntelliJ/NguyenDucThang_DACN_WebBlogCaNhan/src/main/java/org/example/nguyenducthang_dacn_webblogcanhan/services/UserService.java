package org.example.nguyenducthang_dacn_webblogcanhan.services;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }
    public void save(User user) {
        LocalDate date = LocalDate.now();
        Date currDate = Date.valueOf(date);

        user.setCreated_at(currDate);
        user.setModified_at(currDate);

        userRepository.save(user);
    }
}
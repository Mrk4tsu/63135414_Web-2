package com.mrkatsu.mywebapp.services;

import com.mrkatsu.mywebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired private IUserRepository repository;
    public List<User> listAll(){
        return (List<User>) repository.findAll();
    }
}
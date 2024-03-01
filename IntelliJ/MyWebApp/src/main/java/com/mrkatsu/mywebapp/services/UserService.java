package com.mrkatsu.mywebapp.services;

import com.mrkatsu.mywebapp.models.User;
import com.mrkatsu.mywebapp.utilities.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private IUserRepository repository;
    public List<User> listAll(){
        return (List<User>) repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }
    public User get(Integer userId) throws UserNotFoundException {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("Can not find User with ID: " + userId);
    }
    public void delete(Integer userId) throws UserNotFoundException {
        Long count = repository.countById(userId);
        if (count == null || count == 0){
            throw new UserNotFoundException("List empty");
        }
        repository.deleteById(userId);
    }
}

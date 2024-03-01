package com.mrkatsu.mywebapp.services;

import com.mrkatsu.mywebapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}

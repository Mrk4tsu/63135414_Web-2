package com.mrkatsu.mywebapp;

import com.mrkatsu.mywebapp.models.User;
import com.mrkatsu.mywebapp.services.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired private IUserRepository userRepository;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setUsername("test04");
        user.setPassword("test");
        user.setAvatar("avatarUser.png");
        user.setFirstname("Nguyễn Văn");
        user.setLastname("Thành");
        user.setActive(true);

        User save = userRepository.save(user);

        assertThat(save).isNotNull();
        assertThat(save.getId()).isGreaterThan(0);
    }
    @Test
    public void testListUser(){
        Iterable<User> listUser = userRepository.findAll();
        assertThat(listUser).hasSizeGreaterThan(0);

        for (User user : listUser){
            System.out.println(user.toString());
        }
    }
    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();
        user.setPassword("katsu123");

        userRepository.save(user);

        User updateUser = userRepository.findById(userId).get();
        assertThat(updateUser.getPassword()).isEqualTo("katsu123");
    }
    @Test
    public void testGetUser(){
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);
        assertThat(optionalUser).isPresent();

        System.out.printf(optionalUser.get().toString());
    }

    @Test
    public void testDelete(){
        Integer userId = 3;
        userRepository.deleteById(userId);

        Optional<User> optionalUser = userRepository.findById(userId);
        assertThat(optionalUser).isNotPresent();

    }
}

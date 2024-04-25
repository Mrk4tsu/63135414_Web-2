package org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
}

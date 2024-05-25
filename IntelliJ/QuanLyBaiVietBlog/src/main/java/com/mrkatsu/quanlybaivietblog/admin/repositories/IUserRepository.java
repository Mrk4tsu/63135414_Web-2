package com.mrkatsu.quanlybaivietblog.admin.repositories;

import com.mrkatsu.quanlybaivietblog.admin.models.User;
import org.springframework.data.jpa.repository.*;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}

package com.mrkatsu.quanlybaivietblog.admin.repositories;

import com.mrkatsu.quanlybaivietblog.admin.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}

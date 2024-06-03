package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}

package com.mrkatsu.quanlybaivietblog.admin.services.interfaces;

import com.mrkatsu.quanlybaivietblog.admin.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Boolean update(Category category);
    Boolean delete(Integer id);
    Category findById(Integer id);
}

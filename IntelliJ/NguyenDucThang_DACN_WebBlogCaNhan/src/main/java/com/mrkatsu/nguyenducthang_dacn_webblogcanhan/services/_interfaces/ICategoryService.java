package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    Category getById(int id);
    Boolean save(Category category);
    Boolean delete(int id);
}

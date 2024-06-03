package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories.ICategoryRepository;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired private ICategoryRepository repository;
    @Override
    public List<Category> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Category getById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Boolean save(Category category) {
        try {
            this.repository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(int id) {
        try {
            this.repository.delete(getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

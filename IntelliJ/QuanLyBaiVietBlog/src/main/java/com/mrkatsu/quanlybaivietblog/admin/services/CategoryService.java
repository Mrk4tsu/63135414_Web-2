package com.mrkatsu.quanlybaivietblog.admin.services;

import com.mrkatsu.quanlybaivietblog.admin.models.Category;
import com.mrkatsu.quanlybaivietblog.admin.repositories.ICategoryRepository;
import com.mrkatsu.quanlybaivietblog.admin.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try {
            this.repository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(Category category) {
        try {
            this.repository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            this.repository.delete(findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Category findById(Integer id) {
        return this.repository.findById(id).get();
    }
}

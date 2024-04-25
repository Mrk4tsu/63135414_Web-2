package org.example.nguyenducthang_dacn_webblogcanhan.services;

import org.example.nguyenducthang_dacn_webblogcanhan.models.Category;
import org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces.ICategoryRepository;
import org.example.nguyenducthang_dacn_webblogcanhan.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository repository;

    public List<Category> listAll() {
        return (List<Category>) repository.findAll();
    }
    public void save(Category category) {
        repository.save(category);
    }
    public Category getByID(Integer categoryId) throws UserNotFoundException {
        Optional<Category> user = repository.findById(categoryId);
        if (user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("Không thể tìm thấy danh mục có ID: " + categoryId);
    }
    public void delete(Integer categoryId) {
        repository.deleteById(categoryId);
    }
}

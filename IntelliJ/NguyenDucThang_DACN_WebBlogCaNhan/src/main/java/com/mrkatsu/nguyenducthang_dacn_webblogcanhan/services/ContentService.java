package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Content;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories.IContentRepository;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService implements IContentService {
    @Autowired
    private IContentRepository repository;

    @Override
    public List<Content> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Content getById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Boolean save(Content content) {
        try {
            this.repository.save(content);
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

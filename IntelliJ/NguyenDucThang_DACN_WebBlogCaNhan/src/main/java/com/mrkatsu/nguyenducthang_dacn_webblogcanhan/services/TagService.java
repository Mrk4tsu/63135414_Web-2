package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Tag;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories.ITagRepository;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService {
    @Autowired private ITagRepository repository;
    @Override
    public List<Tag> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Tag getById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Boolean save(Tag tag) {
        try {
            this.repository.save(tag);
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

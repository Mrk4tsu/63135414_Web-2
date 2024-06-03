package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.TagContent;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories.ITagContentRepository;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces.ITagContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagContentService implements ITagContentService {
    @Autowired private ITagContentRepository repository;

    @Override
    public List<TagContent> getAll() {
        return this.repository.findAll();
    }

    @Override
    public TagContent getById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Boolean save(TagContent tagContent) {
        try {
            this.repository.save(tagContent);
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

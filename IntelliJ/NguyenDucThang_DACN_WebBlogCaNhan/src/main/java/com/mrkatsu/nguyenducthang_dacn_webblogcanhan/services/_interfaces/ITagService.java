package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Tag;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.TagContent;

import java.util.List;

public interface ITagService {
    List<Tag> getAll();
    Tag getById(int id);
    Boolean save(Tag tag);
    Boolean delete(int id);
}

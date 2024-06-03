package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.TagContent;

import java.util.List;

public interface ITagContentService {
    List<TagContent> getAll();
    TagContent getById(int id);
    Boolean save(TagContent tagContent);
    Boolean delete(int id);
}

package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services._interfaces;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Content;

import java.util.List;

public interface IContentService {
    List<Content> getAll();
    Content getById(int id);
    Boolean save(Content content);
    Boolean delete(int id);
}

package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagRepository extends JpaRepository<Tag, Integer> {
}

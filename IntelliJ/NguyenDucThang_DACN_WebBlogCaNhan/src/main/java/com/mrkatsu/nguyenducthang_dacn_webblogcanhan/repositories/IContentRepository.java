package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.repositories;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContentRepository extends JpaRepository<Content, Integer> {
}

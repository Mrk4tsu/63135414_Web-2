package org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces;

import org.example.nguyenducthang_dacn_webblogcanhan.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepository extends CrudRepository<Comment, Integer> {
}

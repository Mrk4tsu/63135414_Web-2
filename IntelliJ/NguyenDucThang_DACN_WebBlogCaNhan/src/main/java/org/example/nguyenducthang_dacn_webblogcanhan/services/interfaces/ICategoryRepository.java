package org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces;

import org.example.nguyenducthang_dacn_webblogcanhan.models.Category;
import org.springframework.data.repository.CrudRepository;
/**
 * ICategoryRepository nhận 2 tham số là Category và Integer
 * Category là đối tượng làm việc
 * Integer là kiểu dữ liệu của khóa chính
 * Mục đích của interface này là để thực hiện các thao tác CRUD với đối tượng Category
 */
public interface ICategoryRepository extends CrudRepository<Category, Integer> {
}

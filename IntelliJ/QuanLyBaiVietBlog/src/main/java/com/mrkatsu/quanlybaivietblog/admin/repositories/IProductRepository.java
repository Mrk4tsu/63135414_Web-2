package com.mrkatsu.quanlybaivietblog.admin.repositories;

import com.mrkatsu.quanlybaivietblog.admin.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}

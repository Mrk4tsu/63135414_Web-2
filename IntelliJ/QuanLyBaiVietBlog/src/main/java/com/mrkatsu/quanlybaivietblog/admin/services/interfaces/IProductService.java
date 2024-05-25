package com.mrkatsu.quanlybaivietblog.admin.services.interfaces;

import com.mrkatsu.quanlybaivietblog.admin.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(int id);
    Boolean add(Product product);
    Boolean update(Product product);
    Boolean delete(int id);
}

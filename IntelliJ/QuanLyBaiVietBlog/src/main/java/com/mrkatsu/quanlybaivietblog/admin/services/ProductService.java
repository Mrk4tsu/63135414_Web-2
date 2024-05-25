package com.mrkatsu.quanlybaivietblog.admin.services;

import com.mrkatsu.quanlybaivietblog.admin.models.Product;
import com.mrkatsu.quanlybaivietblog.admin.repositories.IProductRepository;
import com.mrkatsu.quanlybaivietblog.admin.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired private IProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Boolean add(Product product) {
        try {
            this.productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(Product product) {
        try {
            this.productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(int id) {
        try {
            this.productRepository.delete(getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

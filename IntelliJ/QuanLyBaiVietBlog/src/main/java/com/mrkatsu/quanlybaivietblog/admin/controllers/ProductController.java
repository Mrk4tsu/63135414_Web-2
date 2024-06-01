package com.mrkatsu.quanlybaivietblog.admin.controllers;

import com.mrkatsu.quanlybaivietblog.admin.models.*;
import com.mrkatsu.quanlybaivietblog.admin.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired private CategoryService categoryService;
    @Autowired private ProductService productService;
    @Autowired private FilesStorageService filesStorageService;

    @RequestMapping("/product")
    public String product(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "admin/product/index";
    }
    @GetMapping("/product/add")
    public String addProduct(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);

        model.addAttribute("product", new Product());
        return "admin/product/add-product";
    }
    @PostMapping("/product/add")
    public String saveProduct(@ModelAttribute("product") Product product, @RequestParam("filename") MultipartFile file ) {
        this.filesStorageService.init();
        this.filesStorageService.save(file);
        if (!file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            product.setImage(fileName);

            // Save the file in the file system
            try {
                Path path = Paths.get("uploads/" + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (productService.add(product)) {
            return "redirect:/admin/product";
        }
        return "admin/product/add-product";
    }
}

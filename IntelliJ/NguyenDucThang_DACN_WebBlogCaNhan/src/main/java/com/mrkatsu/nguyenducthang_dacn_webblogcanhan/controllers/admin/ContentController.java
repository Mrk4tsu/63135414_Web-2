package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.controllers.admin;

import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Category;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models.Content;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.CategoryService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.ContentService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.FilesStorageService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.services.UserService;
import com.mrkatsu.nguyenducthang_dacn_webblogcanhan.utils.Utilities;
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
public class ContentController {
    @Autowired
    private ContentService contentService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FilesStorageService filesStorageService;


    @RequestMapping("/content")
    public String index(Model model) {
        var list = contentService.getAll();
        model.addAttribute("list", list);
        return "admin/content/index";
    }
    @GetMapping("/content-detail/{id}")
    public String reservationDetail(@PathVariable("id") int id, Model model) {
        Content content = contentService.getById(id);
        model.addAttribute("content", content);
        return "admin/content/detail";
    }
    @GetMapping("/content/add")
    public String addProduct(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);

        model.addAttribute("content", new Content());
        return "admin/content/add";
    }

    @PostMapping("/content/add")
    public String saveProduct(@ModelAttribute("content") Content content, @RequestParam("filename") MultipartFile file) {
        this.filesStorageService.init();
        String newFilename = this.filesStorageService.newFile(file);
        if (!file.isEmpty()) {
            content.setImage(newFilename);
            // Save the file in the file system
            try {
                Path path = Paths.get("uploads/" + newFilename);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String meta = StringUtils.cleanPath(content.getName());
        content.setMeta_title(meta);
        content.setCreated_at(Utilities.getCurrentDate());
        content.setUpdated_at(Utilities.getCurrentDate());

        if (contentService.save(content)) {
            return "redirect:/admin/content";
        }
        return "admin/content/add";
    }

    @GetMapping("/content/edit/{id}")
    public String saveProduct(Model model, @PathVariable("id") Integer id) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);

        Content content = this.contentService.getById(id);

        model.addAttribute("content", content);
        return "admin/content/edit";
    }

    @PostMapping("/content/edit")
    public String updateProduct(@ModelAttribute("content") Content content, @RequestParam("filename") MultipartFile file) {
        this.filesStorageService.init();

        if (!file.isEmpty()) {
            String newFilename = this.filesStorageService.newFile(file);
            if(newFilename != null && !newFilename.isEmpty()){
                content.setImage(newFilename);
            }
            try {
                Path path = Paths.get("uploads/" + newFilename);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String meta = Utilities.toMetaTitle(content.getName());
        if (content.getMeta_title() == null || content.getMeta_title().isEmpty()) {
            content.setMeta_title(meta);
        }
        content.setCreated_at(Utilities.getCurrentDate());
        content.setUpdated_at(Utilities.getCurrentDate());

        if (contentService.save(content)) {
            return "redirect:/admin/content";
        }
        return "admin/content/edit";
    }

    @GetMapping("/content/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (this.contentService.delete(id)) {
            return "redirect:/admin/content";
        }
        return "admin/content/index";
    }
}

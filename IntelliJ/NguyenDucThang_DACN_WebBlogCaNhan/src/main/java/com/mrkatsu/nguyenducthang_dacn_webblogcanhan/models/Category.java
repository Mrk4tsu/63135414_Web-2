package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "meta_title")
    private String meta_title;
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "updated_at")
    private Date updated_at;
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "category")
    private Set<Content> products;

    public Category() {
    }

    public Category(int id, String name, String meta_title, String keyword, Date created_at, Date updated_at, boolean status, Set<Content> products) {
        this.id = id;
        this.name = name;
        this.meta_title = meta_title;
        this.keyword = keyword;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Content> getProducts() {
        return products;
    }

    public void setProducts(Set<Content> products) {
        this.products = products;
    }
}

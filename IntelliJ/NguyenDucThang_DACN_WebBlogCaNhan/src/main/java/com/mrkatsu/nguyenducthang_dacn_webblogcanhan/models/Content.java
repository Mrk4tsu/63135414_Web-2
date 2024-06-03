package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "meta_title")
    private String meta_title;
    @Column(name = "description")
    private String description;
    @Column(name = "detail", length = 5000)
    private String detail;
    @Column(name = "image")
    private String image;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "updated_at")
    private Date updated_at;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "content", fetch = FetchType.EAGER)
    private Set<TagContent> tagContents;

    public Content() {
    }

    public Content(int id, String name, String meta_title, String description, String detail, String image, Date created_at, String keyword, Date updated_at, boolean status, Category category, Set<TagContent> tagContents) {
        this.id = id;
        this.name = name;
        this.meta_title = meta_title;
        this.description = description;
        this.detail = detail;
        this.image = image;
        this.created_at = created_at;
        this.keyword = keyword;
        this.updated_at = updated_at;
        this.status = status;
        this.category = category;
        this.tagContents = tagContents;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<TagContent> getTagContents() {
        return tagContents;
    }

    public void setTagContents(Set<TagContent> tagContents) {
        this.tagContents = tagContents;
    }
}

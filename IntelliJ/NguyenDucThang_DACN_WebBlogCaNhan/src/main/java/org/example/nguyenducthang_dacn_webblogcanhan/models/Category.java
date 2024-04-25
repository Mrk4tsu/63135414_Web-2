package org.example.nguyenducthang_dacn_webblogcanhan.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private   String meta_title;
    @Column
    private int parent_id;
    @Column
    private int display_order;
    @Column
    private String seo_title;
    @Column
    private String seo_keyword;
    @Column
    private String created_by;
    @Column
    private String modified_by;
    @Column
    private Date created_at;
    @Column
    private Date modified_at;
    @Column
    private boolean show_on_home;
    @Column
    private boolean status;
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

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(int display_order) {
        this.display_order = display_order;
    }

    public String getSeo_title() {
        return seo_title;
    }

    public void setSeo_title(String seo_title) {
        this.seo_title = seo_title;
    }

    public String getSeo_keyword() {
        return seo_keyword;
    }

    public void setSeo_keyword(String seo_keyword) {
        this.seo_keyword = seo_keyword;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public boolean isShow_on_home() {
        return show_on_home;
    }

    public void setShow_on_home(boolean show_on_home) {
        this.show_on_home = show_on_home;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

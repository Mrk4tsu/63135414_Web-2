package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER)
    private Set<TagContent> tagContents;
    public Tag() {
    }

    public Tag(String id, String name, Set<TagContent> tagContents) {
        this.id = id;
        this.name = name;
        this.tagContents = tagContents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TagContent> getTagContents() {
        return tagContents;
    }

    public void setTagContents(Set<TagContent> tagContents) {
        this.tagContents = tagContents;
    }
}

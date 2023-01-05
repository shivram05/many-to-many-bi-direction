package com.many.to.many.manytomany.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Tag(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "tag")
    private Collection<Post> posts;
}

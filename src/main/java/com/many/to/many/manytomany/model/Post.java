package com.many.to.many.manytomany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
    @Column(name = "posted_at")
    private Date postedAt = new Date();
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_tags",
            joinColumns = {
                    @JoinColumn(name = "post_id")},
            inverseJoinColumns = @JoinColumn(name = "tag_id")

    )
    private Collection<Tag> tag;

    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }
}

package com.many.to.many.manytomany.repository;

import com.many.to.many.manytomany.model.Post;
import com.many.to.many.manytomany.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}

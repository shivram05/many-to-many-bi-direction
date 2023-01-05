package com.many.to.many.manytomany;

import com.many.to.many.manytomany.model.Post;
import com.many.to.many.manytomany.model.Tag;
import com.many.to.many.manytomany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Post post = new Post("Hibernate Many to Many Mapping Example with Spring Boot",
                "Hibernate Many to Many Mapping Example with Spring Boot",
                "Hibernate Many to Many Mapping Example with Spring Boot");

        Post post1 = new Post("Hibernate One to Many Mapping Example with Spring Boot",
                "Hibernate One to Many Mapping Example with Spring Boot",
                "Hibernate One to Many Mapping Example with Spring Boot");

        Tag springBoot = new Tag("Spring Boot");
        Tag hibernate = new Tag("Hibernate");

        // add tag references post
        post.getTag().add(springBoot);
        post.getTag().add(hibernate);

        // add post references tag

        springBoot.getPosts().add(post);
        hibernate.getPosts().add(post);

        springBoot.getPosts().add(post1);
        post1.getTag().add(springBoot);


        postRepository.save(post);
        postRepository.save(post1);
    }
}

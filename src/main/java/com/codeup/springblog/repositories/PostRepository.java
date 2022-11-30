package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

Post findById(long id);
List<Post> findAllByOwner(User user);

List<Post> findAllByTitle(String title);



}

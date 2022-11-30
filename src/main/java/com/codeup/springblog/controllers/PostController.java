package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping("/posts")
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    //Automatic Dependency Injection for PostRepository into our PostController using a constructor

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }




//    @GetMapping
//    public String postPage(Model model){
//        Post post1 = new Post(1, "First", "This is my first post!!!");
//        Post post2 = new Post(2, "Second", "Hey everyone, I'm baaaack");
//        List<Post> allPosts = new ArrayList<>(List.of(post1, post2));
//        model.addAttribute("allPosts", allPosts);
//        return "/posts/index";
//    }


    @GetMapping("/posts")
    public String viewAllPosts(Model model){
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "index";
    }

    @GetMapping("/posts/create")
    public String postPage(){
        return "create";
    }

//    @PostMapping("/posts/create")
//    public String submitPost(@RequestParam(name= "title") String title, @RequestParam(name="body") String body){
//        User user = userDao.findById(1);
//        Post post = new Post(title, body, user);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post post){
        User user = userDao.findById(1);
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit-post/{id}")
    public String editPostForm(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "edit-post";
    }

    @PostMapping("/posts/edit-post/{id}")
    public String saveEditPost(@PathVariable long id, @ModelAttribute Post post){
        User user = userDao.findById(1);
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts";
    }



    @GetMapping("/posts/{id}")
    public String postIndividual(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/show";

    }//End of postIndividual method


}

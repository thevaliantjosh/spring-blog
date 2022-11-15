package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("posts")
    @ResponseBody
    public String postPage(){
        return "<h1>Posts index page<h1>";
    }

    @GetMapping("posts/{id}")
    @ResponseBody
    public String postIndividual(@PathVariable String id){
        return "<h1>You are now viewing the post: <h1>" + id;
    }

    @GetMapping("posts/create")
    @ResponseBody
    public String createPost(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatedPost(){
        return "create a new post";
    }


}

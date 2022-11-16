package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    @GetMapping
    @ResponseBody
    public String postPage(){
        return "<h1>Posts index page<h1>";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String postIndividual(@PathVariable String id){
        return "<h1>You are now viewing the post: <h1>" + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost(){
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postCreatedPost(){
        return "create a new post";
    }


}

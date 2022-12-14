package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository usersDao;

    public UserController(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "users/registration";
    }

    @PostMapping("/register")
    public String saveRegistration(@ModelAttribute User user){
        usersDao.save(user);
        return"redirect:/posts/create";
    }


}

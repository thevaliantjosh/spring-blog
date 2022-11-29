package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/roll-dice")
public class DiceController {

    @GetMapping
    public String dicePage(){
        return "roll-dice";
    }

    @GetMapping("/{guess}")
    public String numbers(@PathVariable int guess, Model model){
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("guess",  guess);
        return "roll-dice";
    }


}

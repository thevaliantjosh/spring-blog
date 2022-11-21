package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/roll-dice")
public class DiceController {

    @GetMapping
    public String dicePage(){
        return "roll-dice";
    }

    @GetMapping("/{number}")
    public String numbers(@PathVariable String number, Model model){
        Dice random = null;
        Dice selection1 = new Dice("1");
        Dice selection2 = new Dice("2");
        Dice selection3 = new Dice("3");
        Dice selection4 = new Dice("4");
        Dice selection5 = new Dice("5");
        Dice selection6 = new Dice("6");

        List<Dice> selections = new ArrayList<>(List.of(selection1, selection2, selection3, selection4, selection5, selection6));
        model.addAttribute("random", random);
        for (Dice usersChoice : selections){
            if (usersChoice.getNumber() == random.rollDice()){
                random = usersChoice;
            }
        }
        model.addAttribute("selections",  selections);
        return "/roll-dice";
    }


}

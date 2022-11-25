package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Supplier;
import com.codeup.springblog.repositories.CoffeeRepository;
import com.codeup.springblog.repositories.SupplierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeRepository coffeeDao;

    private final SupplierRepository suppliersDao;

    public CoffeeController(CoffeeRepository coffeeDao, SupplierRepository suppliersDao){
        this.coffeeDao = coffeeDao;
        this.suppliersDao = suppliersDao;
    }

    @GetMapping
    public String coffee(){
        return "coffee";
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
        Coffee selection = new Coffee(roast, "Cool Beans");
        Coffee selection2 = new Coffee(roast, "Coffee Bros");
        selection.setOrigin("Ethipia");
        selection2.setOrigin("Vietnam");
        List<Coffee> selections = new ArrayList<>(List.of(selection, selection2));
        model.addAttribute("selections", selections);
        return "coffee";
    }

    @GetMapping("/all-coffees")
    public String allCoffees(Model model){
        List<Coffee> coffees = coffeeDao.findAll();
        model.addAttribute("coffees", coffees);
        return "all-coffees";
    }

    @GetMapping("/new")
    public String addCoffeeForm(Model model){
        List<Supplier> suppliers = suppliersDao.findAll();
        model.addAttribute("suppliers", suppliers);
        return "create-coffee";
    }

    @PostMapping("/new")
    public String addCoffee(@RequestParam(name="roast") String roast, @RequestParam(name="origin") String origin, @RequestParam(name="brand") String brand, @RequestParam(name="supplier") long id){
//        Supplier supplier = suppliersDao.findById(id);
//        Coffee coffee = new Coffee(roast, origin, brand, supplier);
//        coffeeDao.save(coffee);
        return "redirect:/coffee/all-coffees";

    }



    @GetMapping("/suppliers")
    public String showSupplierForm(Model model){
        List<Supplier> suppliers = suppliersDao.findAll();
        model.addAttribute("suppliers", suppliers);
        return "/suppliers";
    }


    @PostMapping("/suppliers")
    public String insertSuppliers(@RequestParam(name="name") String name){
        Supplier supplier = new Supplier(name);
        suppliersDao.save(supplier);
        return "redirect:/suppliers";
    }





}//End of CoffeeController

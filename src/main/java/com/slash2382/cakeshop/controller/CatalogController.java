package com.slash2382.cakeshop.controller;


import com.slash2382.cakeshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String getItems(Model model){

        model.addAttribute("users",  itemService.getAllItems());
        return "greeting";
    }

}

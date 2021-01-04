package com.slash2382.cakeshop.controller;


import com.slash2382.cakeshop.service.CatalogService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService itemService) {
        this.catalogService = itemService;
    }

    @GetMapping("/")
    ModelAndView index(){
        return  new ModelAndView("catalog", Map.of("items", this.catalogService.getItems()));}

}

package com.slash2382.cakeshop.basket;

import com.slash2382.cakeshop.basket.Basket;
import com.slash2382.cakeshop.catalog.Item;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/basket")
class BasketController {

    private final Basket basket;

    BasketController(Basket basket) {
        this.basket = basket;
    }

    @PostMapping
    String addToBasket(@RequestParam String sku) {
        this.basket.add(sku);
        return "redirect:/";
    }

    @GetMapping
    ModelAndView showBasket() {
        return new ModelAndView("basket", Map.of("basketTotal", basket.getTotalItems(), "items", basket.getItems()));
    }

    @PostMapping("/delete")
    String removeFromBasket(@RequestParam String sku) {
        this.basket.remove(sku);
        return "redirect:/basket";
    }

}
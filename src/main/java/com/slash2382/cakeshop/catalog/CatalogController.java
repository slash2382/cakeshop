package com.slash2382.cakeshop.catalog;
import com.slash2382.cakeshop.basket.Basket;
import com.slash2382.cakeshop.catalog.CatalogService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CatalogController {

    private final CatalogService catalogService;
    private final Basket basket;

    CatalogController(CatalogService catalogService, Basket basket) {
        this.catalogService = catalogService;
        this.basket = basket;
    }

    @GetMapping("/")
    ModelAndView index() {

        return new ModelAndView("catalog", Map.of("items", this.catalogService.getItems(), "basketTotal", this.basket.getTotalItems()));
    }

}

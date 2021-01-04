package com.slash2382.cakeshop.controller;

import static org.assertj.core.api.Assertions.assertThat;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.slash2382.cakeshop.dto.Item;
import com.slash2382.cakeshop.service.CatalogService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;


import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CatalogController.class)
class CatalogControllerTest {

    private WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CatalogService catalogService;

    @BeforeEach
    void setup() {this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();}

    @Test
    @DisplayName("index page returns home page")
    void returnsHomePage() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Cake Factory")));
    }

    @Test
    @DisplayName("home page returns a list of items from database")
    void returnListOfItemsFromDb() throws Exception{
        final String expectedTitle = "Red Velvet";
        mockItems(expectedTitle, BigDecimal.valueOf(3));

        HtmlPage page = webClient.getPage("http://localhost/");

        assertThat(page.querySelectorAll(".item-title")).anyMatch(domElement -> expectedTitle.equals(domElement.asText()));
    }

    private void mockItems(String title, BigDecimal price) {
        when(catalogService.getItems()).thenReturn(Collections.singletonList(new Item(title, price)));
    }


}
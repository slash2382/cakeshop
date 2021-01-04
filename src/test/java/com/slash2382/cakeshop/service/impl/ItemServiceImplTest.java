package com.slash2382.cakeshop.service.impl;

import com.slash2382.cakeshop.domain.ItemEntity;
import com.slash2382.cakeshop.dto.Item;
import com.slash2382.cakeshop.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@DataJpaTest
@ActiveProfiles("test")
class ItemServiceImplTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ItemRepository itemRepository;

    private ItemServiceImpl itemService;

    @BeforeEach
    void setup() {this.itemService = new ItemServiceImpl(this.itemRepository);}

    @Test
    @DisplayName("should return data from database")
    void returnsDataFromDatabase(){
        String expectedTitle = "Victoria Sponge";
        saveTestItem(expectedTitle, BigDecimal.valueOf(5.55));

        Iterable<Item> items = itemService.getItems();

        org.assertj.core.api.Assertions.assertThat(items).anyMatch(item -> expectedTitle.equals(item.getTitle()));
    }

    private void saveTestItem(String title, BigDecimal price) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setSku("test-item-1");
        itemEntity.setTitle(title);
        itemEntity.setPrice(price);

        testEntityManager.persistAndFlush(itemEntity);
    }

}
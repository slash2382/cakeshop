package com.slash2382.cakeshop.service.impl;

import com.slash2382.cakeshop.dto.Item;
import com.slash2382.cakeshop.repository.ItemRepository;
import com.slash2382.cakeshop.service.CatalogService;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class ItemServiceImpl implements CatalogService {


    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getItems() {
        return  StreamSupport.stream(itemRepository.findAll().spliterator(), false)
                .map(item -> new Item(item.getTitle(), item.getPrice()))
                .collect(Collectors.toList());
    }
}

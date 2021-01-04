package com.slash2382.cakeshop.service.impl;

import com.slash2382.cakeshop.domain.Catalog;
import com.slash2382.cakeshop.repository.ItemRepository;
import com.slash2382.cakeshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Catalog save(Catalog item) {
        return null;
    }

    @Override
    public Catalog getById(Long id) {
        return null;
    }

    @Override
    public List<Catalog> getAllItems() {
        return itemRepository.findAll();
    }
}

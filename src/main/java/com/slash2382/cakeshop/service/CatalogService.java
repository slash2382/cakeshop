package com.slash2382.cakeshop.service;

import com.slash2382.cakeshop.domain.ItemEntity;
import com.slash2382.cakeshop.dto.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogService {

    Iterable<Item> getItems();

}

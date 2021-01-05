package com.slash2382.cakeshop.catalog;

import org.springframework.stereotype.Service;

@Service
public interface CatalogService {

    Iterable<Item> getItems();

    Item getItemBySku(String sku);

}

package com.slash2382.cakeshop.catalog.persistence;


import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import com.slash2382.cakeshop.catalog.CatalogService;
import com.slash2382.cakeshop.catalog.Item;
import org.springframework.stereotype.Component;

@Component
class JpaCatalogService implements CatalogService {

    private final ItemRepository itemRepository;

    JpaCatalogService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(), false)
                .map(this::mapEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Item getItemBySku(String sku) {
        ItemEntity entity = this.itemRepository.findBySku(sku);
        if (entity == null) {
            return null;
        }

        return mapEntity(entity);
    }

    Item mapEntity(ItemEntity entity) {
        return new Item(entity.sku, entity.title, entity.price);
    }

}

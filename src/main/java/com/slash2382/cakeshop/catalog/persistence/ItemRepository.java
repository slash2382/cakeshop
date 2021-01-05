package com.slash2382.cakeshop.catalog.persistence;

import com.slash2382.cakeshop.catalog.persistence.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, String> {

    ItemEntity findBySku(String sku);
}

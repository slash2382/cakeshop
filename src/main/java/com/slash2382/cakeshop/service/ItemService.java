package com.slash2382.cakeshop.service;

import com.slash2382.cakeshop.domain.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    Catalog save(Catalog item);

    Catalog getById(Long id);

    List<Catalog> getAllItems();

}

package com.slash2382.cakeshop.repository;

import com.slash2382.cakeshop.domain.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Catalog, Long> {

    List<Catalog> findAll();
}

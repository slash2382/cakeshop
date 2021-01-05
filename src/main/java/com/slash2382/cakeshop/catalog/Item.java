package com.slash2382.cakeshop.catalog;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Item {

    final private String sku;
    final private String title;
    final private BigDecimal price;

}
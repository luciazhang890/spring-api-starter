package com.codewithmosh.store.dtos;

import lombok.Data;
import org.hibernate.query.SelectionQuery;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Byte categoryId;
}

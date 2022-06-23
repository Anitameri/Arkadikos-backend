package com.arcade.arkadicos.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto
{
    private String name, description;

    private float price;

    private String category, image;

    private long units, rating, user_id;
}
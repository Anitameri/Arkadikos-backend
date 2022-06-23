package com.arcade.arkadicos.orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto
{
    private long user_id, product_id;

    private float price;

    private long units;
}
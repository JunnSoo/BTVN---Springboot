package com.springbootapi.btvnbuoi34.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private double price;
    private String description;
}

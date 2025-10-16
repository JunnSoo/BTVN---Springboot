package com.springbootapi.btvnbuoi34.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class productDto {
    private int id;
    private String name;
    private double price;
    private String description;
}

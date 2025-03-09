package com.nence.nence_v1.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDto {

    private String name;

    private int price;

    private int stock;
}

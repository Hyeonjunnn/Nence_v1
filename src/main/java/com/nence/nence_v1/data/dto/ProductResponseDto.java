package com.nence.nence_v1.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private Long number;

    private String name;

    private int price;

    private int stock;
}

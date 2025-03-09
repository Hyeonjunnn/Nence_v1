package com.nence.nence_v1.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ChangeProductNameDto {

    private Long number;

    private String name;
}

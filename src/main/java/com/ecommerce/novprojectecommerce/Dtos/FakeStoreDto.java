package com.ecommerce.novprojectecommerce.Dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class FakeStoreDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

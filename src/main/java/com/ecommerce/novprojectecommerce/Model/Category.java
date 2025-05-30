package com.ecommerce.novprojectecommerce.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category extends Base {

    private String name ;
    private String description;

    @OneToMany
    private List<Product> products;

//    public Category (String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
}

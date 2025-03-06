package com.ecommerce.novprojectecommerce.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Category extends Base {

    private String name ;
    private String description;

//    public Category (String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
}

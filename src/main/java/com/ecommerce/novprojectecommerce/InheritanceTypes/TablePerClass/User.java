package com.ecommerce.novprojectecommerce.InheritanceTypes.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data

@Entity(name = "TPC_Users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private long id ;
    private String name;
    private String email;
}

package com.ecommerce.novprojectecommerce.InheritanceTypes.SingleTable;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity(name = "st_Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
public class User {
    @Id
    private long id ;
    private String name;
    private String email;
}

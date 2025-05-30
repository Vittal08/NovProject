package com.ecommerce.novprojectecommerce.InheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data

@Entity(name = "jt_Users")// used to set the table name
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private long id ;
    private String name;
    private String email;
}

package com.ecommerce.novprojectecommerce.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "st_Students")
@DiscriminatorValue("3")
public class Student extends User {
    private double psp ;
}

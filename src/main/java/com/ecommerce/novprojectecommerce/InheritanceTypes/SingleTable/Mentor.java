package com.ecommerce.novprojectecommerce.InheritanceTypes.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "st_Mentors")
@DiscriminatorValue("2")
public class Mentor extends User {
    private String Company;
}

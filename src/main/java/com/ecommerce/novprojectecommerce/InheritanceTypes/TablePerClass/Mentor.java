package com.ecommerce.novprojectecommerce.InheritanceTypes.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
//import jakarta.*;
import lombok.Data;

@Data
@Entity(name = "TPC_Mentors")

//@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private String Company;
}

package com.ecommerce.novprojectecommerce.InheritanceTypes.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "TPC_Students")
//@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private double psp ;
}

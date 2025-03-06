package com.ecommerce.novprojectecommerce.InheritanceTypes.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "TPC_Instructors ")

//@PrimaryKeyJoinColumn(name = "user_id")   // we dont need to this annotation because we are not going to join the tables to get the data
public class Instructor extends User {
    private String module ;
}

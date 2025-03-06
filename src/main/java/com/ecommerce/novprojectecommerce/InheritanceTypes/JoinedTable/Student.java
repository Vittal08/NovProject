package com.ecommerce.novprojectecommerce.InheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_Students")
@PrimaryKeyJoinColumn(name = "user_id")

public class Student extends User{
    private double psp ;
}
package com.ecommerce.novprojectecommerce.InheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_Mentors")
@PrimaryKeyJoinColumn(name = "user_id")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Mentor extends User{
    private String Company;
}

package com.ecommerce.novprojectecommerce.InheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_Instructors ")// we are naming the table and creating one in the Db here!!

@PrimaryKeyJoinColumn(name = "user_id") 
public class Instructor extends User{
    private String module ;
}

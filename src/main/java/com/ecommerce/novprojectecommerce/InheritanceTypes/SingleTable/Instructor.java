package com.ecommerce.novprojectecommerce.InheritanceTypes.SingleTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
@Data
@Entity(name = "st_Instructors ")
//@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("1")
public class Instructor extends User {
    private String module ;
}
package com.ecommerce.novprojectecommerce.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Entity
@Data
public class Product extends Base {

    private String title ;
    private Double price ;
    @ManyToOne
    private Category category ;
}
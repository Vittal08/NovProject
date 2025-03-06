package com.ecommerce.novprojectecommerce.Controllers;

import com.ecommerce.novprojectecommerce.Dtos.FakeStoreDto;
import com.ecommerce.novprojectecommerce.Exceptions.ProductNotFoundExeption;
import com.ecommerce.novprojectecommerce.Model.Product;
import com.ecommerce.novprojectecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


        //TODO how to add the @Qualifier in the configuration file

    //TODO how to add the @Qualifier in the configuration file

    ProductService ps;
    public ProductController(@Qualifier("dbProductService") ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id")long id) throws ProductNotFoundExeption,RuntimeException {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                ps.getProductById(id), HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/All")
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(
                ps.getAllProducts(), HttpStatus.OK
        );
        return responseEntity;
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id")Long id) throws ProductNotFoundExeption {
        ps.deleteProduct(id);
    }

    @PostMapping ("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(ps.addProduct(product),HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("id") Long id) throws ProductNotFoundExeption {
        ResponseEntity<Product> productt =  new ResponseEntity<>(ps.updateProduct( id ,product ),HttpStatus.OK);
        return productt;
    }
}
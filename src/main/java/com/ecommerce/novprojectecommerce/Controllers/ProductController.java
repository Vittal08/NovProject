package com.ecommerce.novprojectecommerce.Controllers;

import com.ecommerce.novprojectecommerce.Dtos.FakeStoreDto;
import com.ecommerce.novprojectecommerce.Exceptions.ProductNotFoundExeption;
import com.ecommerce.novprojectecommerce.Model.Product;
import com.ecommerce.novprojectecommerce.Projections.ProductSummary;
import com.ecommerce.novprojectecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService ps;
    public ProductController( @Qualifier("dbProductService") ProductService ps) {
        this.ps = ps;
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
        ResponseEntity<Product> responseEntity =  new ResponseEntity<>(ps.updateProduct( id ,product ),HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/summary/{id}")
    public ResponseEntity<ProductSummary> getDetailsOfProductById(@PathVariable("id") Long id) throws  ProductNotFoundExeption{
        ResponseEntity<ProductSummary> response = new ResponseEntity<>(ps.getProductSummary(id),HttpStatus.OK);
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id")long id) throws ProductNotFoundExeption,RuntimeException {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                ps.getProductById(id), HttpStatus.OK
        );
        return responseEntity;
    }
    //TODO NEED TO LEARN ABOUT CASCADE IN CARDINALITIES
}
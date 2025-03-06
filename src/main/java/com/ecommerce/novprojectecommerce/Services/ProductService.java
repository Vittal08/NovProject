package com.ecommerce.novprojectecommerce.Services;

import com.ecommerce.novprojectecommerce.Dtos.FakeStoreDto;
import com.ecommerce.novprojectecommerce.Exceptions.ProductNotFoundExeption;
import com.ecommerce.novprojectecommerce.Model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundExeption;
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Long id ,Product product ) throws ProductNotFoundExeption;
    void deleteProduct(Long id ) throws ProductNotFoundExeption;
}

package com.ecommerce.novprojectecommerce.Services;

import com.ecommerce.novprojectecommerce.Exceptions.ProductNotFoundExeption;
import com.ecommerce.novprojectecommerce.Model.Product;
import com.ecommerce.novprojectecommerce.Projections.ProductSummary;
import com.ecommerce.novprojectecommerce.Repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class DbProductService implements ProductService{
//    Dependency Injection
    ProductRepository pr;

    DbProductService(ProductRepository pr){
        this.pr = pr ;
    }


    public Product getProductById(Long id) throws ProductNotFoundExeption {
        Optional<Product> optionalProduct = pr.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundExeption("Product with id : "+ id+" does not exist ");
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return pr.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundExeption {
         Optional<Product> optionalProduct = pr.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundExeption("Product with id "+ id + " is not found ");
        }
        Product prod = optionalProduct.get();
        if (product.getTitle() != null){
            prod.setTitle(product.getTitle());
        }
        if (product.getCategory() != null){
            prod.setCategory(product.getCategory());
        }
        if (product.getPrice() != null){
            prod.setPrice(product.getPrice());
        }
        return pr.save(prod);// save method is used to create and update a product
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundExeption {
        Optional<Product> optionalProduct = pr.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundExeption("Product with id " +
                    + id + " is not found ");
        }
        pr.deleteById(id);
    }

    @Override
    public ProductSummary getProductSummary(Long id) throws ProductNotFoundExeption {
        Optional<Product> optionalProduct = pr.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundExeption("Product with id "+ id + " is not found ");
        }
        Product product = optionalProduct.get();
        ProductSummary ps = pr.getProductDetails(product.getId());
        return ps;
    }

    @Override
    public String getProductDesc(Long id) throws ProductNotFoundExeption {
        return null;
    }

//    @Override
//    public List<Product>findSimilarProducts(String title) {
//
//    }

}

package com.ecommerce.novprojectecommerce.Repository;
import com.ecommerce.novprojectecommerce.Model.Product;
import com.ecommerce.novprojectecommerce.Projections.ProductSummary;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    /* we need to mention the model class / the table name and its primary key(Long ,Integer , etc)
     we are dealing with the Jpa Repository and with its primary key of the table  */

    List<Product>findProductByPriceGreaterThan(Double price );

    List<Product> findProductByTitleLike(String title);

    List<Product> findProductByTitleLike(String title, Limit limit);

    Optional<Product> findById(Long id);// this is an in built method no need to declare in the repository
//    this is Hql (Hibernate Query Language)
    @Query("select p.title as title,p.price as price  from Product p where p.id = :productId")
    ProductSummary getProductDetails(Long productId);


//    using Native Query
    @Query(nativeQuery = true, value = "Select p.title as title , p.price as price from Product p where p.id = :productId ")
    ProductSummary getProductDetailsByNative(Long productId);

}
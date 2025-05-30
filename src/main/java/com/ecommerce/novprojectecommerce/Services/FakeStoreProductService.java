package com.ecommerce.novprojectecommerce.Services;
import com.ecommerce.novprojectecommerce.Dtos.FakeStoreDto;
import com.ecommerce.novprojectecommerce.Exceptions.ProductNotFoundExeption;
import com.ecommerce.novprojectecommerce.Model.Category;
import com.ecommerce.novprojectecommerce.Model.Product;
import com.ecommerce.novprojectecommerce.Projections.ProductSummary;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    RestTemplate rt ;

    public FakeStoreProductService(RestTemplate rt) {
        this.rt = rt;
    }

    public Product getProductById(Long id) {

        FakeStoreDto dto = rt.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreDto.class);
        if (dto == null ){
            return new Product();
        }
        return ConvertFsdtoToProduct(dto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreDto[] dtos = rt.getForObject("https://fakestoreapi.com/products", FakeStoreDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreDto dto : dtos ){
            products.add(ConvertFsdtoToProduct(dto));
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) {
//        Product product = ConvertFsdtoToProduct(dto);
//        rt.postForObject("https://fakestoreapi.com/products", product, Product.class);
        return null;
    }

    @Override
    public Product updateProduct(Long id,Product product ) {
        RequestCallback requestCallback = rt.httpEntityCallback(product, FakeStoreDto.class);
        HttpMessageConverterExtractor<FakeStoreDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreDto.class, rt.getMessageConverters());
        FakeStoreDto dto = rt.execute(   
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor
        );
        return ConvertFsdtoToProduct(dto);
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductSummary getProductSummary(Long id) throws ProductNotFoundExeption {
        return null;
    }

    @Override
    public String getProductDesc(Long id) throws ProductNotFoundExeption {
        return "";
    }

//        Convert FakeStoreProductDto into Product

    public  Product ConvertFsdtoToProduct(FakeStoreDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setPrice(dto.getPrice());
        product.setTitle(dto.getTitle());
//        Category cat = new Category(dto.getCategory(),dto.getDescription());
//        product.setCategory(cat);
        return product ;
    }
}
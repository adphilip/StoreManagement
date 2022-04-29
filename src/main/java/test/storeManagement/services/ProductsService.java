package test.storeManagement.services;

import test.storeManagement.dtos.ProductDto;

import java.util.List;

public interface ProductsService {
    List<ProductDto> getProducts();
    ProductDto getProduct(long id);
    void createProduct(ProductDto product);
    void updateProduct(long id, ProductDto product);
}

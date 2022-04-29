package test.storeManagement.dataAccess;

import test.storeManagement.models.Product;

import java.util.List;

public interface ProductsProvider {
    Product findProduct(long id);
    List<Product> returnAllProducts();
    void createProduct(Product product);
    void updateProduct(long id, Product product);
}

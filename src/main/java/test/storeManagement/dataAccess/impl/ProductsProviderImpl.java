package test.storeManagement.dataAccess.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.storeManagement.dataAccess.ProductsProvider;
import test.storeManagement.models.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductsProviderImpl implements ProductsProvider {
    @Override
    public Product findProduct(long id) {
        var result = Product.builder()
                .id(id)
                .name("name" + id)
                .price(BigDecimal.valueOf(56))
                .build();

        return result;
    }

    @Override
    public List<Product> returnAllProducts() {
        var result = Arrays.asList(Product.builder()
                        .id(1)
                        .name("name1")
                        .price(BigDecimal.valueOf(133))
                        .build(),
                Product.builder()
                        .id(2)
                        .name("name2")
                        .price(BigDecimal.valueOf(89))
                        .build());

        return result;
    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(long id, Product product) {

    }
}

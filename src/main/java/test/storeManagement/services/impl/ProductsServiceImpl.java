package test.storeManagement.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import test.storeManagement.dataAccess.ProductsProvider;
import test.storeManagement.dtos.ProductDto;
import test.storeManagement.models.Product;
import test.storeManagement.services.ProductsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private ProductsProvider productsProvider;

    @Override
    @PreAuthorize("hasRole('STANDARD')")
    public List<ProductDto> getProducts() {
        var result = productsProvider.returnAllProducts()
                .stream()
                .map(p -> ProductDto.builder()
                        .name(p.getName())
                        .id(p.getId())
                        .price(p.getPrice())
                        .build())
                .collect(Collectors.toList());

        return result;
    }

    @Override
    @PreAuthorize("hasRole('STANDARD')")
    public ProductDto getProduct(long id) {
        var product = productsProvider.findProduct(id);

        if (product == null) {
            return null;
        }

        return ProductDto.builder()
                .name(product.getName())
                .id(product.getId())
                .price(product.getPrice())
                .build();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void createProduct(ProductDto product) {
        log.info("Creating product: " + product);

        productsProvider.createProduct(Product.builder()
                        .name(product.getName())
                        .id(product.getId())
                        .price(product.getPrice())
                        .build());
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void updateProduct(long id, ProductDto product) {
        productsProvider.updateProduct(id, Product.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build());
    }
}

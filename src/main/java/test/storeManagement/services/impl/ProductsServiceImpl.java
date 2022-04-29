package test.storeManagement.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import test.storeManagement.dtos.ProductDto;
import test.storeManagement.services.ProductsService;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductsServiceImpl implements ProductsService {
    @Override
    @PreAuthorize("hasRole('STANDARD')")
    public List<ProductDto> getProducts() {
        var result = Arrays.asList(ProductDto.builder()
                        .id(1)
                        .name("name1")
                        .build(),
                ProductDto.builder()
                        .id(2)
                        .name("name2")
                        .build());

        return result;
    }

    @Override
    @PreAuthorize("hasRole('STANDARD')")
    public ProductDto getProduct(long id) {
        var result = ProductDto.builder()
                .id(id)
                .name("name" + id)
                .build();

        return result;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void createProduct(ProductDto product) {
        log.info("Creating product: " + product);
    }
}

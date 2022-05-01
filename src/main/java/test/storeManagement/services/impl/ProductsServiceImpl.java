package test.storeManagement.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import test.storeManagement.dataAccess.ProductsRepository;
import test.storeManagement.dtos.ProductDto;
import test.storeManagement.entities.ProductEntity;
import test.storeManagement.services.ProductsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private ProductsRepository productsRepository;

    @Override
    @PreAuthorize("hasRole('STANDARD')")
    public List<ProductDto> getProducts() {
        var result = productsRepository.findAll()
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
        var product = productsRepository.findById(id);

        return product.map(p -> ProductDto.builder()
                .name(p.getName())
                .id(p.getId())
                .price(p.getPrice())
                .build()).orElse(null);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void createProduct(ProductDto product) {
        log.info("Creating product: " + product);

        productsRepository.save(ProductEntity.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .build());
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void updateProduct(long id, ProductDto product) {
        var existingEntityOptional = productsRepository.findById(id);

        if (existingEntityOptional.isPresent()) {
            var existingEntity = existingEntityOptional.get();
            existingEntity.setPrice(product.getPrice());
            existingEntity.setName(product.getName());

            productsRepository.save(existingEntity);
        }
    }
}

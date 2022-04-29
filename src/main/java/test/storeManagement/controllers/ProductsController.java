package test.storeManagement.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import test.storeManagement.dtos.ProductDto;
import test.storeManagement.services.ProductsService;

import java.util.List;

@RestController
@RequestMapping("products")
@Slf4j
@AllArgsConstructor
public class ProductsController {

    ProductsService productsService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productsService.getProducts();
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable long id) {
        return productsService.getProduct(id);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto product) {
        productsService.createProduct(product);
    }

    @PutMapping(value = "/{id}")
    public void updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) {
        productsService.updateProduct(id, productDto);
    }
}

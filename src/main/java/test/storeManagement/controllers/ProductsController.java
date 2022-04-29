package test.storeManagement.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}

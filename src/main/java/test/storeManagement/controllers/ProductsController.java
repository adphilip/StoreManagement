package test.storeManagement.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.storeManagement.dtos.ProductDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductsController {

    @GetMapping
    public List<ProductDto> getProducts() {
        log.info("Entered get");
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
}

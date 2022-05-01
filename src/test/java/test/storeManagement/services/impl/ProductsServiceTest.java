package test.storeManagement.services.impl;

import org.junit.Assert;
import org.junit.Test;
import test.storeManagement.dataAccess.ProductsRepository;
import test.storeManagement.entities.ProductEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductsServiceTest {
    @Test
    public void getAllProductsTest() {
        var productsRepositoryMock = mock(ProductsRepository.class);

        when(productsRepositoryMock.findAll()).thenReturn(Arrays.asList(ProductEntity.builder()
                        .id(1L)
                        .name("name1")
                        .price(BigDecimal.valueOf(133))
                        .build(),
                ProductEntity.builder()
                        .id(2L)
                        .name("name2")
                        .price(BigDecimal.valueOf(89))
                        .build()));

        var productsService = new ProductsServiceImpl(productsRepositoryMock);

        var result = productsService.getProducts();
        Assert.assertEquals(2, result.size());

        Assert.assertEquals("name1", result.get(0).getName());
        Assert.assertEquals("name2", result.get(1).getName());
        Assert.assertEquals(BigDecimal.valueOf(133), result.get(0).getPrice());
    }

    @Test
    public void getProductTest() {
        var productsRepositoryMock = mock(ProductsRepository.class);

        var testProduct = ProductEntity.builder()
                .id(4L)
                .name("name4")
                .price(BigDecimal.valueOf(4))
                .build();
        when(productsRepositoryMock.findById(4L)).thenReturn(Optional.of(testProduct));

        var productsService = new ProductsServiceImpl(productsRepositoryMock);

        var product = productsService.getProduct(4);

        Assert.assertEquals((long)testProduct.getId(), product.getId());
        Assert.assertEquals(testProduct.getName(), product.getName());
        Assert.assertEquals(testProduct.getPrice(), product.getPrice());
    }

    @Test
    public void getProductWithNullTest() {
        var productsRepositoryMock = mock(ProductsRepository.class);

        when(productsRepositoryMock.findById(4L)).thenReturn(Optional.empty());

        var productsService = new ProductsServiceImpl(productsRepositoryMock);

        var product = productsService.getProduct(4);

        Assert.assertNull(product);
    }
}

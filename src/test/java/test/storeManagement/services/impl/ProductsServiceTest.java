package test.storeManagement.services.impl;

import org.junit.Assert;
import org.junit.Test;
import test.storeManagement.dataAccess.ProductsProvider;
import test.storeManagement.models.Product;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductsServiceTest {
    @Test
    public void getAllProductsTest() {
        var productsProviderMock = mock(ProductsProvider.class);

        when(productsProviderMock.returnAllProducts()).thenReturn(Arrays.asList(Product.builder()
                        .id(1)
                        .name("name1")
                        .price(BigDecimal.valueOf(133))
                        .build(),
                Product.builder()
                        .id(2)
                        .name("name2")
                        .price(BigDecimal.valueOf(89))
                        .build()));

        var productsService = new ProductsServiceImpl(productsProviderMock);

        var result = productsService.getProducts();
        Assert.assertEquals(2, result.size());

        Assert.assertEquals("name1", result.get(0).getName());
        Assert.assertEquals("name2", result.get(1).getName());
        Assert.assertEquals(BigDecimal.valueOf(133), result.get(0).getPrice());
    }

    @Test
    public void getProductTest() {
        var productsProviderMock = mock(ProductsProvider.class);

        var testProduct = Product.builder()
                .id(4)
                .name("name4")
                .price(BigDecimal.valueOf(4))
                .build();
        when(productsProviderMock.findProduct(4)).thenReturn(testProduct);

        var productsService = new ProductsServiceImpl(productsProviderMock);

        var product = productsService.getProduct(4);

        Assert.assertEquals(testProduct.getId(), product.getId());
        Assert.assertEquals(testProduct.getName(), product.getName());
        Assert.assertEquals(testProduct.getPrice(), product.getPrice());
    }

    @Test
    public void getProductWithNullTest() {
        var productsProviderMock = mock(ProductsProvider.class);

        when(productsProviderMock.findProduct(4)).thenReturn(null);

        var productsService = new ProductsServiceImpl(productsProviderMock);

        var product = productsService.getProduct(4);

        Assert.assertNull(product);
    }
}

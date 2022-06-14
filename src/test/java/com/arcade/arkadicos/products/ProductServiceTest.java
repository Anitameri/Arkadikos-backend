package com.arcade.arkadicos.products;

import jdk.jfr.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock private ProductRepository productRepositoryMock;

    private ProductService productServiceUnderTest;

    @BeforeEach
    void setUp() {
        productServiceUnderTest = new ProductService(productRepositoryMock);
    }

    @Test
    void canGetAllProducts() {

        //When
        productServiceUnderTest.getAllProducts();
        //Then
        verify(productRepositoryMock).findAll();
    }

    @Test
    void canGetProductById() {

        //When
        productServiceUnderTest.getProductById(1L);

        ArgumentCaptor<Long> productIdArgumentCaptor = ArgumentCaptor.forClass(Long.class);

        //Then
        verify(productRepositoryMock).findById(productIdArgumentCaptor.capture());

        Long capturedProductId = productIdArgumentCaptor.getValue();

        assertThat(capturedProductId).isEqualTo(1L);
    }

    @Test
    void canCreateProduct(){
        // Give

        Product product = new Product(
                "Fifa 97",
                "Videojuego MegaDrive Fifa 97",
                10,
                "videojuegos",
                "https://m.media-amazon.com/images/I/71Zy3qmKRLL._AC_SY500_.jpg"
        );

        Mockito.when(productServiceUnderTest.create(product)).thenReturn(product);

        //When

        Product productActual = productServiceUnderTest.create(product);
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);

        //Then

        verify(productRepositoryMock).save(productArgumentCaptor.capture());

        Product capturedProduct = productArgumentCaptor.getValue();

        assertThat(capturedProduct).isEqualTo(product);
        assertThat(productActual).isEqualTo(product);
    }

    @Test

    void canUpdateProduct() {
        //Given
        Product product = new Product(
                1L,
                "Fifa 97",
                "Videojuego MegaDrive Fifa 97",
                10,
                "videojuegos",
                "https://m.media-amazon.com/images/I/71Zy3qmKRLL._AC_SY500_.jpg"
        );
        Mockito.when(productServiceUnderTest.update(product)).thenReturn(product);

        //When
        Product productUpdated = productServiceUnderTest.update(product);
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);

        //Then
        verify(productRepositoryMock).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();

        assertThat(capturedProduct).isEqualTo(product);
        assertThat(productUpdated).isEqualTo(product);

    }

    @Test

    void canDeleteProduct(){
        //Give ****ojo a si queremos no mandar objeto entero***
        Product product = new Product(
                1L,
                "Fifa 97",
                "Videojuego MegaDrive Fifa 97",
                10,
                "videojuegos",
                "https://m.media-amazon.com/images/I/71Zy3qmKRLL._AC_SY500_.jpg"
        );

        //When
        productServiceUnderTest.deleteById(product.getId());

        //Then
        verify(productRepositoryMock).deleteById(product.getId());
    }


}
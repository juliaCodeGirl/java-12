package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(1, "Война и Мир", 1000);

    @Test
    void shouldMatchByName() {
        String name = "Война и Мир";
        product.matches(name);

        assertTrue(product.matches(name));
    }

    @Test
    void shouldMatchNotExistingByName(){
        String name = "Три мушкетера";
        product.matches(name);

        assertFalse(product.matches(name));
    }
}
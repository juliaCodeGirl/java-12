package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(1, "Война и Мир", 1000);

    @Test
    void shouldMatchByName() {
        String name = "Война и Мир";

        assertTrue(product.matches(name));
    }

    @Test
    void shouldMatchNotExistingByName(){
        String name = "Три мушкетера";

        assertFalse(product.matches(name));
    }
}
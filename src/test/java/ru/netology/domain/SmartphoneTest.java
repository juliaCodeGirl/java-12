package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(4, "Redmi", 8000, "Xiaomi");

    @Test
    void shouldMatchByName() {
        String namePhone = "Redmi";

        assertTrue(smartphone.matches(namePhone));
    }

    @Test
    void shouldMatchByProducer() {
        String producerPhone = "Xiaomi";

        assertTrue(smartphone.matches(producerPhone));
    }

    @Test
    void shouldMatchNotExistingByProducer() {
        String producerPhone = "Apple";

        assertFalse(smartphone.matches(producerPhone));
    }

    @Test
    void shouldMatchNotExistingByName() {
        String namePhone = "IPhone";

        assertFalse(smartphone.matches(namePhone));
    }

}
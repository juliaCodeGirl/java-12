package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(4, "Redmi", 8000, "Xiaomi");

    @Test
    void shouldMatchByName() {
        String namePhone = "Redmi";
        smartphone.matches(namePhone);

        assertTrue(smartphone.matches(namePhone));
    }

    @Test
    void shouldMatchByProducer() {
        String producerPhone = "Xiaomi";
        smartphone.matches(producerPhone);

        assertTrue(smartphone.matches(producerPhone));
    }

    @Test
    void shouldMatchNotExistingByProducer() {
        String producerPhone = "Apple";
        smartphone.matches(producerPhone);

        assertFalse(smartphone.matches(producerPhone));
    }

    @Test
    void shouldMatchNotExistingByName() {
        String namePhone = "IPhone";
        smartphone.matches(namePhone);

        assertFalse(smartphone.matches(namePhone));
    }

}
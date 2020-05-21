package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(2, "Евгений Онегин", 800, "Пушкин");

    @Test
    void  shouldMatchByAuthor() {
        String authorBook = "Пушкин";

        assertTrue(book.matches(authorBook));
    }

    @Test
    void  shouldMatchNotExistingByAuthor() {
        String authorBook = "Гоголь";

        assertFalse(book.matches(authorBook));
    }

    @Test
    void  shouldMatchByName() {
        String authorBook = "Евгений Онегин";

        assertTrue(book.matches(authorBook));
    }

    @Test
    void  shouldMatchNotExistingByName() {
        String authorBook = "Мертвые души";

        assertFalse(book.matches(authorBook));
    }

}
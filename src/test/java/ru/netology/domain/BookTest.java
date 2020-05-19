package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(2, "Евгений Онегин", 800, "Пушкин");

    @Test
    void  shouldMatchByAuthor() {
        String authorBook = "Пушкин";
        book.matches(authorBook);

        assertTrue(book.matches(authorBook));
    }

    @Test
    void  shouldMatchNotExistingByAuthor() {
        String authorBook = "Гоголь";
        book.matches(authorBook);

        assertFalse(book.matches(authorBook));
    }

    @Test
    void  shouldMatchByName() {
        String authorBook = "Евгений Онегин";
        book.matches(authorBook);

        assertTrue(book.matches(authorBook));
    }

    @Test
    void  shouldMatchNotExistingByName() {
        String authorBook = "Мертвые души";
        book.matches(authorBook);

        assertFalse(book.matches(authorBook));
    }

}
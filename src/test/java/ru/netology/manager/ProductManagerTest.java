package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Book first = new Book(1, "Война и Мир", 1000, "Толстой");
    private Book second = new Book(2, "Евгений Онегин", 800, "Пушкин");
    private Book third = new Book(3, "Galaxy", 1200, "Коршунов");

    private Smartphone xiaomi = new Smartphone(4, "Redmi", 8000, "Xiaomi");
    private Smartphone nokia = new Smartphone(5, "Phone", 9000, "Nokia");
    private Smartphone samsung = new Smartphone(6, "Galaxy", 8000, "Samsung");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(xiaomi);
        manager.add(nokia);
        manager.add(samsung);
    }

    @Test
    void shouldFindExistingBookByName() {
        String nameBook = "Евгений Онегин";
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(nameBook);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindExistingBookByAuthor() {
        String authorBook = "Толстой";
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy(authorBook);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNotExistingBookByName() {
        String nameBook = "Три мушкетера";
        manager.searchBy(nameBook);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(nameBook);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNotExistingBookByAuthor() {
        String authorBook = "Гоголь";
        manager.searchBy(authorBook);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(authorBook);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindExistingPhoneByName() {
        String namePhone = "Phone";
        manager.searchBy(namePhone);
        Product[] expected = new Product[]{nokia};
        Product[] actual = manager.searchBy(namePhone);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindExistingPhoneByProducer() {
        String producerPhone = "Xiaomi";
        manager.searchBy(producerPhone);
        Product[] expected = new Product[]{xiaomi};
        Product[] actual = manager.searchBy(producerPhone);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNotExistingPhoneByName() {
        String namePhone = "IPhone";
        manager.searchBy(namePhone);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(namePhone);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNotExistingPhoneByProducer() {
        String producerPhone = "FLY";
        manager.searchBy(producerPhone);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(producerPhone);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookAndPhoneByName() {
        manager.add(third);
        String nameBookPhone = "Galaxy";
        Product[] expected = new Product[]{samsung, third};
        Product[] actual = manager.searchBy(nameBookPhone);

        assertArrayEquals(expected, actual);
    }
}

package ru.netology.repository;
import org.junit.jupiter.api.Test;
import ru.netology.service.Book;
import ru.netology.service.Product;
import ru.netology.service.Smartphone;

import static org.junit.jupiter.api.Assertions.*;
public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product book = new Book(100, "First Book", 400, "First Author");
    Product smartphone = new Smartphone(120, "iPhone", 80000, "Apple");
    Product product = new Product(130, "Milk", 80);
    @Test
    public void shouldSaveOneItem() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAll() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = { book, smartphone, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldRemoveById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(120);
        Product[] expected = { book, product };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveAllById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(100);
        repository.removeById(120);
        repository.removeById(130);
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}


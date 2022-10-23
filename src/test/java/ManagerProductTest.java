import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.awt.SystemColor.text;
import static org.junit.jupiter.api.Assertions.*;

class ManagerProductTest {

    Repository repo = new Repository();
    ManagerProduct manager = new ManagerProduct(repo);

    Book book1 = new Book(1, "book1", 100, "Author1");
    Book book2 = new Book(2, "book2", 100, "Author1");
    Book book3 = new Book(3, "book3", 100, "Author2");
    Book book4 = new Book(4, "gazeta4", 100, "Author3");

    @Test
    public void addBooksToTheRepository() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSomeBooks() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("magazine");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdBooks() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesBooks() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("book1");

        Assertions.assertArrayEquals(expected, actual);
    }



}
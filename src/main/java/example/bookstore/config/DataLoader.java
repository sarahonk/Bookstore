package example.bookstore.config;

import example.bookstore.model.Book;
import example.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // kirjatiedot
        Book book1 = new Book("Title 1", "Author 1", 2000, "ISBN 1", 19.99);
        Book book2 = new Book("Title 2", "Author 2", 2005, "ISBN 2", 29.99);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}

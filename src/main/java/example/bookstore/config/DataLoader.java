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
        Book book1 = new Book("Sienihullu", "Anu Barsk", 2022, "9789523732827", 25.80);
        Book book2 = new Book("Hilppa Hömötiainen", "Seija Helander", 2019, "9789525960914", 12.95);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}

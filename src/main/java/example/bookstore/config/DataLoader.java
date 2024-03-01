package example.bookstore.config;

import example.bookstore.model.Book;
import example.bookstore.model.Category;
import example.bookstore.repository.BookRepository;
import example.bookstore.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        logger.info("DataLoader is running...");

        // kirjat
        Book book1 = new Book("Sienihullu", "Anu Barsk", 2022, "9789523732827", 25.80);
        Book book2 = new Book("Hilppa Hömötiainen", "Seija Helander", 2019, "9789525960914", 12.95);

        bookRepository.save(book1);
        bookRepository.save(book2);

        logger.info("Kirjatiedot tallennettu");

        // kategoriat
        Category category1 = new Category("Sci-Fi");
        Category category2 = new Category("Comic");

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        logger.info("Kategoriat tallennettu");

        // kirjojen haku ja loggaaminen
        List<Book> books = bookRepository.findAll();
        logger.info("Kirjatiedot");
        for (Book book : books) {
            logger.info("Title: {}, Author: {}, Publication Year: {}, ISBN: {}, Price: {}",
                    book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getIsbn(), book.getPrice());
        }
    }
}

package dal;


import dao.Author;
import dao.Book;

import java.util.List;

public interface BookDao {
    void save(Book entity);

    List<Book> findBooks();

    List<Book> findBooksByGenre();

    Book findById(Long bookId);

    List<Book> findByAuthorId(Long userId);

    List<Book> findByPattern(String bookName);
}

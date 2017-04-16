package dal;


import dao.Author;
import dao.Book;

import java.util.List;

public interface BookDao {
    void save(Book entity);

    List<Book> findFirstFifty();

    Book findById(Long bookId);
}

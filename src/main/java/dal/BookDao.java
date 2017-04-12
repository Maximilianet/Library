package dal;


import dao.Book;

public interface BookDao {
    void save(Book entity);

    void deleteBook(String name);
}

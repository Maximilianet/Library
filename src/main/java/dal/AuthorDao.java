package dal;

import dao.Author;
import dao.Book;

import java.util.List;

public interface AuthorDao {
    void save(Author entity);

    Author findById(Long authorId);

    Author findByFirstNameAndLastName(String firstName, String lastName);
}

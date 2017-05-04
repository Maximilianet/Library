package dal;

import dao.Author;

import java.util.List;

public interface AuthorDao {
    void save(Author entity);

    Author findById(int authorId);

    Author findByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAll();
}

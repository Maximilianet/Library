package service;

import dal.AuthorDao;
import dal.BookDao;
import dao.Author;
import dao.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private  AuthorDao authorDao;

    @Autowired
    private BookDao bookDao;

    public void saveNewAuthor(Author author){

    }

    public List<Author> findAll() {
        List<Author> list = authorDao.findAll();
        return list;
    }

    public Book findById(long id) {
        Book list = bookDao.findById(id);
        return list;
    }
}

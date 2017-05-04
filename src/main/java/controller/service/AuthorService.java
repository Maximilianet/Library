package controller.service;

import dal.AuthorDao;
import dao.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private  AuthorDao authorDao;

    public void saveNewAuthor(Author author){

    }

    public List<Author> findAll() {
        List<Author> list = authorDao.findAll();
        return list;
    }

    public Author findById(int id){
        Author author = authorDao.findById(id);
        return author;
    }
}

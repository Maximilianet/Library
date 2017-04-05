package service;

import dal.AuthorDao;
import dao.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public void saveNewAuthor(Author author){

    }
}

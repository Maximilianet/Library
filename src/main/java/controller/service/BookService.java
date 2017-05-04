package controller.service;


import dal.BookDao;
import dao.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> findBooks(){
        List<Book> bookList = bookDao.findBooks();
        return bookList;
    }

    public Book findById(long id) {
        Book list = bookDao.findById(id);
        return list;
    }

    public Book findByName(String name){
        Book book = (Book) bookDao.findBooks();
        return book;
    }
}

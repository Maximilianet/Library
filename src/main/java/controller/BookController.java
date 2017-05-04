package controller;

import dal.impl.BookDaoImpl;
import dao.Author;
import dao.Book;
import mainLogic.SpringHibernateMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import controller.service.BookService;
import controller.service.AuthorService;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String showAllAuthors(ModelMap model) {
        List<Author> author = authorService.findAll();

        List<Book> bookMainPage = bookService.findBooks();
        model.addAttribute("authorInfo", author);
        model.addAttribute("booksList", bookMainPage);
        return "main";
    }

    @RequestMapping(value = "/searchBook", method = RequestMethod.POST)
    public String searchBook(@ModelAttribute("findBook") Book findBook){
        String bookName = findBook.getName();

        return "main";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String showBook(@PathVariable("id") long id, ModelMap modelMap){
        Book book = bookService.findById(id);
        modelMap.addAttribute("bookInfo", book);

        return "Books/book";
    }
}
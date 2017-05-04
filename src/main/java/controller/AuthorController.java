package controller;

import dao.Author;
import dao.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import controller.service.AuthorService;
import controller.service.BookService;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public ModelAndView index() {
        String message = "Message from public class UserController";
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String showAllAuthors(ModelMap model) {

        List<Author> allAuthors = authorService.findAll();
        model.addAttribute("authors", allAuthors);

        return "Authors/list";
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public String showInfo(@PathVariable("id") int id, ModelMap model) {

        Book books = bookService.findById(id);
        model.addAttribute("authorBooks", books);

        Author author = authorService.findById(id);
        model.addAttribute("authorInfo", author);

        return "Authors/showAuthor";
    }
//    @RequestMapping(value = "/student", method = RequestMethod.POST)
//    public String addStudent(@ModelAttribute("SpringWeb") Author author, ModelMap modelMap){
//    modelMap.addAttribute("")
//
//    return "result";
//}
}


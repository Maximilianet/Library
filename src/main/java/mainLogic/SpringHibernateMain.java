package mainLogic;

import dal.AuthorDao;
import dal.BookDao;
import dao.Author;
import dao.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		AuthorDao authorDao = context.getBean(AuthorDao.class);
		BookDao bookDao = context.getBean(BookDao.class);

		Author newAuthor = new Author();
		newAuthor.setFirstName("Mikhail");
		newAuthor.setLastName("Bulgakov");

		Book newBook = new Book();
		newBook.setName("The Master and Margarita");
		newBook.setPrice(1000);
		newBook.setReview("...");
		newBook.setRating(10);

		authorDao.save(newAuthor);
		bookDao.save(newBook);

		context.close();
	}

}

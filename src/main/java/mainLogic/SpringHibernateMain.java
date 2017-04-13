package mainLogic;

import dal.AuthorDao;
import dal.BookDao;
import dal.impl.BookDaoImpl;
import dao.Author;
import dao.Book;
import interfaceData.BookPageData;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SpringHibernateMain {
	Connection c;
	Statement stmt;
	String sql;

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		AuthorDao authorDao = context.getBean(AuthorDao.class);
		BookDao bookDao = context.getBean(BookDao.class);


		context.close();
	}


//	public static void deleteByTitle(String title) {
//		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
//		String sql = "DELETE FROM java_books.book WHERE name ='" +title +"'";
//		jdbc.execute(sql);
//		System.out.println(title + "удалена успешно");
//	}

	private static void openMainPage(AuthorDao authorDao, BookDao bookDao){
		BookDaoImpl bookPageDataList = new BookDaoImpl();
		List<Book> bookList = bookPageDataList.findFirstFifty();

		List<BookPageData> bookPageData =
		List<BookPageData> bookPageDataList =
	}

	private static ResultSet startMainWindow() throws SQLException { //Пункт 1
		SpringHibernateMain ma = new SpringHibernateMain();
		ResultSet resultSet = ma.stmt.executeQuery("SELECT name FROM java_books.book");
		return resultSet;
	}

	private static void createAuthorsAndBooks(AuthorDao authorDao, BookDao bookDao) {
		Author newAuthor1 = new Author();
		newAuthor1.setFirstName("Михаил");
		newAuthor1.setLastName("Булгаков");
		authorDao.save(newAuthor1);

		Book newBook1 = new Book();
		newBook1.setName("Мастер и Маргарита");
		newBook1.setPrice(1000);
		newBook1.setReviews("...");
		newBook1.setRating(10);
		newBook1.setAuthor(newAuthor1);
		bookDao.save(newBook1);

		Author newAuthor2 = new Author();
		newAuthor2.setFirstName("Александр");
		newAuthor2.setLastName("Пушкин");
		authorDao.save(newAuthor2);

		Book newBook2 = new Book();
		newBook2.setName("Евгений Онегин");
		newBook2.setPrice(1000);
		newBook2.setReviews("...");
		newBook2.setRating(10);
		newBook2.setAuthor(newAuthor2);
		bookDao.save(newBook2);

		Author newAuthor3 = new Author();
		newAuthor3.setFirstName("Михаил");
		newAuthor3.setLastName("Лермонтов");
		authorDao.save(newAuthor3);

		Book newBook3 = new Book();
		newBook3.setName("Герой нашего времени");
		newBook3.setPrice(1000);
		newBook3.setReviews("...");
		newBook3.setRating(10);
		newBook3.setAuthor(newAuthor3);
		bookDao.save(newBook3);

		Author newAuthor4 = new Author();
		newAuthor4.setFirstName("Федор");
		newAuthor4.setLastName("Достоевский");
		authorDao.save(newAuthor4);

		Book newBook4 = new Book();
		newBook4.setName("Преступление и наказание");
		newBook4.setPrice(450);
		newBook4.setReviews("...");
		newBook4.setRating(8);
		newBook4.setAuthor(newAuthor4);
		bookDao.save(newBook4);

		Author newAuthor5 = new Author();
		newAuthor5.setFirstName("Джек");
		newAuthor5.setLastName("Лондон");
		authorDao.save(newAuthor5);

		Book newBook5 = new Book();
		newBook5.setName("Мартин Иден");
		newBook5.setPrice(320);
		newBook5.setReviews("...");
		newBook5.setRating(10);
		newBook5.setAuthor(newAuthor5);
		bookDao.save(newBook5);

		Author newAuthor6 = new Author();
		newAuthor6.setFirstName("Лев");
		newAuthor6.setLastName("Толстой");
		authorDao.save(newAuthor6);

		Book newBook6 = new Book();
		newBook6.setName("Война и мир");
		newBook6.setPrice(1000);
		newBook6.setReviews("...");
		newBook6.setRating(8);
		newBook6.setAuthor(newAuthor6);
		bookDao.save(newBook6);

		Author newAuthor7 = new Author();
		newAuthor7.setFirstName("Николай");
		newAuthor7.setLastName("Гоголь");
		authorDao.save(newAuthor7);

		Book newBook7 = new Book();
		newBook7.setName("Мертвые души");
		newBook7.setPrice(1000);
		newBook7.setReviews("...");
		newBook7.setRating(7);
		newBook7.setAuthor(newAuthor7);
		bookDao.save(newBook7);

		Author newAuthor8 = new Author();
		newAuthor8.setFirstName("Антон");
		newAuthor8.setLastName("Чехов");
		authorDao.save(newAuthor8);

		Book newBook8= new Book();
		newBook8.setName("Гранатовый браслет");
		newBook8.setPrice(1000);
		newBook8.setReviews("...");
		newBook8.setRating(9);
		newBook8.setAuthor(newAuthor8);
		bookDao.save(newBook8);
	}

}

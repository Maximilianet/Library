package mainLogic;

import dal.AuthorDao;
import dal.BookDao;
import dao.Author;
import dao.Book;
import interfaceData.AuthorPageData;
import interfaceData.BookPageData;
import interfaceData.TitlePageData;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class SpringHibernateMain {

	private static String sortByColumn = "rating";
	private static int maxNumOfBooks = 100;
	private static String sortByGenre = "";

	public static String getSortByColumn() {
		return sortByColumn;
	}

	public static void setSortByColumn(String sortByColumn) {
		SpringHibernateMain.sortByColumn = sortByColumn;
	}

	public static int getMaxNumOfBooks() {
		return maxNumOfBooks;
	}

	public static void setMaxNumOfBooks(int maxNumOfBooks) {
		SpringHibernateMain.maxNumOfBooks = maxNumOfBooks;
	}

	public static String getSortByGenre() {
		return sortByGenre;
	}

	public static void setSortByGenre(String sortByGenre) {
		SpringHibernateMain.sortByGenre = sortByGenre;
	}

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		AuthorDao authorDao = context.getBean(AuthorDao.class);
		BookDao bookDao = context.getBean(BookDao.class);

//		createAuthorsAndBooks(authorDao,bookDao);

		List<TitlePageData> bookPageData = openMainPage(authorDao,bookDao);
        System.out.println("\n\n" + "-- Main page");
        for (TitlePageData t : bookPageData){
            System.out.println(t.getName() + ", " +t.getAuthorFullName() + ", " + t.getGenre()+ ", " + t.getRating() + ", " + t.getPrice());
        }


        Long bookId = 2L;
		BookPageData bookPage = findSingleBook(authorDao,bookDao, bookId);
		System.out.println("\n\n" + "-- Book page");
		System.out.println(bookPage.getName() + ", "
				+ bookPage.getAuthorFullName() + ", "
				+ bookPage.getGenre()+ ", "
				+ bookPage.getRating() + ", "
				+ bookPage.getPrice() + ", "
				+ bookPage.getReviews()
		);


		String authorFirstName = "Михаил";
		String authotLastName = "Булгаков";
		Author authorInfo = findAuthorInfo(authorDao, authorFirstName, authotLastName);
		System.out.println("\n\n" + "-- Author information");
		System.out.println(authorInfo);


		List<TitlePageData> allAuthorBooks = findAuthorBooks(authorDao, bookDao, authorFirstName, authotLastName);
		System.out.println("\n\n" + "-- All author books");
		for (TitlePageData t : allAuthorBooks) {
			System.out.println(t.toString());
		}

		context.close();
	}

	private static List<TitlePageData> findAuthorBooks(AuthorDao authorDao, BookDao bookDao, String firstName, String lastName) {
		Author author = authorDao.findByFirstNameAndLastName(firstName,lastName);

		Long authorId = author.getId();
		List<Book> authorBooksList = bookDao.findByAuthorId(authorId);

		List<TitlePageData> authorBooks = mapToTitlePageData(authorBooksList,authorDao);

		return authorBooks;
	}

	private static Author findAuthorInfo(AuthorDao authorDao, String firstName, String lastName){
		Author author = authorDao.findByFirstNameAndLastName(firstName, lastName);

		return author;
	}

	private static BookPageData findSingleBook(AuthorDao authorDao, BookDao bookDao, Long bookId) {
		Book book = bookDao.findById(bookId);

		BookPageData data = new BookPageData();

		int authorId = book.getAuthorId();
		Author author = authorDao.findById(authorId);
		String authorFullName = author.getFirstName() + " " + author.getLastName();
		data.setAuthorFullName(authorFullName);

		data.setGenre(book.getGenre());
		data.setName(book.getName());
		data.setPrice(book.getPrice());
		data.setRating(book.getRating());
		data.setReviews(book.getReviews());

		return data;
	}

	private static List<TitlePageData> openMainPage(AuthorDao authorDao, BookDao bookDao) {
        List<Book> bookList = bookDao.findBooks();

        List<TitlePageData> titlePageData = mapToTitlePageData(bookList, authorDao);

        return titlePageData;
    }

	private static List<TitlePageData> openMainPageByGenre(AuthorDao authorDao, BookDao bookDao) {
		List<Book> bookList = bookDao.findBooksByGenre();

		List<TitlePageData> titlePageData = mapToTitlePageData(bookList, authorDao);

		return titlePageData;
	}

    private static List<TitlePageData> mapToTitlePageData(List<Book> bookList, AuthorDao authorDao) {
        List<TitlePageData> dataList = new ArrayList<>();

        for (Book book : bookList){

			TitlePageData titlePageData= new TitlePageData();

            int authorId = book.getAuthorId();
            Author author = authorDao.findById(authorId);
            String authorFullName = author.getFirstName() + " " + author.getLastName();
            titlePageData.setAuthorFullName(authorFullName);

            titlePageData.setGenre(book.getGenre());
            titlePageData.setName(book.getName());
            titlePageData.setPrice(book.getPrice());
            titlePageData.setRating(book.getRating());

            dataList.add(titlePageData);
        }

        return dataList;
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
		newBook1.setGenre("Роман");
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
		newBook2.setGenre("Роман");
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
		newBook3.setGenre("Реализм");
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
		newBook4.setGenre("Роман");
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
		newBook5.setGenre("Роман");
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
		newBook6.setGenre("Роман");
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
		newBook7.setGenre("Поэма");
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
		newBook8.setGenre("Повесть");
		bookDao.save(newBook8);
	}
}
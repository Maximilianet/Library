package dal.impl;

import dal.BookDao;
import dal.mapper.AuthorRowMapper;
import dal.mapper.BookRowMapper;
import dao.Author;
import dao.Book;
import mainLogic.SpringHibernateMain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void save(Book entity){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(entity);

        tx.commit();
        session.close();
    }

    public Book findById(Long bookId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_BOOKS.BOOK"
                + " WHERE ID = ?";

        Book book = (Book) jdbcTemplate.queryForObject(
                sql,
                new Object[] {bookId},
                new BookRowMapper(Book.class)
        );

        return book;
    }

    public List<Book> findBooks(){
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_BOOKS.BOOK "
//                + " "+getSortByGenre()+ " "
                + " ORDER BY BOOK.ID "
                + " FETCH FIRST 50 ROWS ONLY ";
        System.out.println(sql);
        List<Book> books = jdbc.query(
                sql,
                new BookRowMapper(Book.class)
        );

        return books;
    }

    public List<Book> findBooksByGenre(){
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_BOOKS.BOOK "
                + " WHERE genre = 'Роман' "
                + " ORDER BY BOOK.ID ASC "
                + " FETCH FIRST 50 ROWS ONLY ";

        List<Book> books = jdbc.query(
                sql,
                new BookRowMapper(Book.class)
        );

        return books;
    }

    public List<Book> findByAuthorId(Long authorId) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM java_books.book "
                + " WHERE BOOK.author_id = " + authorId + " "
                + " ORDER BY BOOK.rating DESC "
                + " FETCH FIRST 50 ROWS ONLY ";

        List<Book> authorBooks  = jdbc.query(
                sql,
                new BookRowMapper(Book.class)
        );

        return authorBooks;
    }

    @Override
    public List<Book> findByPattern(String bookName) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = "" +
                " SELECT * FROM JAVA_BOOKS.BOOK " +
                " WHERE name LIKE '%" + bookName + "%' " +
                " ORDER BY BOOK.ID " +
                " FETCH FIRST 50 ROWS ONLY ";

        List<Book> books = jdbc.query(sql,new BookRowMapper(Book.class));

        return books;
    }
}
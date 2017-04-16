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

    public List<Book> findFirstFifty(){
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_BOOKS.BOOK "
                + " ORDER BY BOOK."+SpringHibernateMain.getSort()+" DESC "
                + " FETCH FIRST "+ SpringHibernateMain.getMaxNumOfBooks() +" ROWS ONLY ";

        List<Book> books = jdbc.query(
                sql,
                new BookRowMapper(Book.class)
        );

        return books;
    }
}
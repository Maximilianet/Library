package dal.impl;

import dal.AuthorDao;
import dal.mapper.AuthorRowMapper;
import dal.mapper.BookRowMapper;
import dao.Author;
import dao.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Author entity){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
    }

    public Author findById(Long authorId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_BOOKS.AUTHOR"
                + " WHERE ID = ?";

        Author author = (Author) jdbcTemplate.queryForObject(
                sql,
                new Object[] {authorId},
                new AuthorRowMapper(Author.class)
        );

        return author;
    }

    public Author findByFirstNameAndLastName(String firstName, String lastName){
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = ""
                + " SELECT * FROM JAVA_BOOKS.AUTHOR "
                + " WHERE FIRST_NAME = ? "
                + " AND LAST_NAME = ? ";

        Author author = (Author) jdbc.queryForObject(
                sql,
                new Object[] { firstName, lastName },
                new AuthorRowMapper(Author.class)
        );

        return author;
    }
}

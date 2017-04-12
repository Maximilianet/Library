package dal.impl;

import dal.BookDao;
import dao.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;

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


    public void deleteBook(String name){
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        String sql = "SELECT id FROM java_books.book WHERE name ='"+ name + "'";
        jdbc.execute(sql);
    }
}

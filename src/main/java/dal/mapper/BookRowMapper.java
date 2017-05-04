package dal.mapper;

import dao.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper extends BeanPropertyRowMapper{

    public BookRowMapper(Class mappedClass) {
        super(mappedClass);
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("ID"));
        book.setName(rs.getString("NAME"));
        book.setPrice(rs.getInt("PRICE"));
        book.setReviews(rs.getString("REVIEWS"));
        book.setRating(rs.getInt("RATING"));
        book.setAuthorId(rs.getInt("AUTHOR_ID"));
        book.setGenre(rs.getString("GENRE"));

        return book;
    }
}

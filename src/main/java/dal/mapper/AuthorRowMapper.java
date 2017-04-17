package dal.mapper;

import dao.Author;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper extends BeanPropertyRowMapper{

    public AuthorRowMapper(Class mappedClass) {
        super(mappedClass);
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getLong("ID"));
        author.setFirstName(rs.getString("FIRST_NAME"));
        author.setLastName(rs.getString("LAST_NAME"));
        return author;
    }
}

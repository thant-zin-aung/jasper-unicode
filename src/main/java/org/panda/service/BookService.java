package org.panda.service;

import org.panda.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    JdbcTemplate jdbcTemplate;

    public BookService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Book> getAllBooks() {
//        return jdbcTemplate.queryForList("SELECT * FROM books", Book.class);
        return jdbcTemplate.query("SELECT * FROM books", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(rs.getString("title"),rs.getString("author"),
                        rs.getString("releaseYear"),rs.getString("titleTranslate"));
            }
        });
    }
}

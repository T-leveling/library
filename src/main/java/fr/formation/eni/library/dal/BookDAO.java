package fr.formation.eni.library.dal;

import fr.formation.eni.library.bo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO {

    final String SELECT = "SELECT * FROM book";
    final String INSERT = "INSERT INTO book(title,description,nb_pages) VALUES(:title,:description,:nbPages)";
    final String SELECT_BY_ID = "SELECT * FROM book WHERE id_book= ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    RowMapper<Book> mapper = (rs, i) -> new Book(rs.getInt("id_book"),rs.getString("title"), rs.getString("description"),
            rs.getInt("nb_pages"));


    public List<Book> getAll() {
        return jdbcTemplate.query(SELECT, mapper);
    }

    public void insert(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(book);
        namedParameterJdbcTemplate.update(INSERT, namedParameters,keyHolder);
        book.setIdBook(keyHolder.getKey().intValue());
        System.out.println("Insertion du Livre :" +book);
    }

    public Book findByiD(Integer idBook) {
       var sql = "SELECT * from BOOK where id_book = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), idBook);
    }
}

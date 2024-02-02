package fr.formation.eni.library.dal;


import fr.formation.eni.library.bo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
public class BookDAOTests {

    @Autowired
    BookDAO dao;

    @Test
    @Transactional
    void contextLoads(){
        Book book = new Book("Harry Potter", "Aventure à l'école des soriciers", 500);
        Book book2 = new Book("Harry Potter2", "Aventure à l'école des soriciers", 350);
        Book book3 = new Book("Harry Potter3", "Aventure à l'école des soriciers", 400);

        dao.insert(book);
        dao.insert(book2);
        dao.insert(book3);

        List<Book> books = dao.getAll();
        books.forEach(System.out::println);
    }
}

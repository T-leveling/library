package fr.formation.eni.library.bll;

import fr.formation.eni.library.bo.Book;
import fr.formation.eni.library.dal.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDAO dao;

    public void addBook(Book book){
        dao.insert(book);
    }

    public List<Book> getAllBooks() {
        return dao.getAll();
    }
}

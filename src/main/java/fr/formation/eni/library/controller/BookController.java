package fr.formation.eni.library.controller;

import fr.formation.eni.library.bll.BookService;
import fr.formation.eni.library.bo.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/ajouterlivre")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "form-book";
    }

    @GetMapping("/library")
    public String getBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "library";
    }


    @PostMapping("/ajouterlivre")
    public String createBook(Authentication authentication, @Valid @ModelAttribute("film") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "accueil";
        } else {
            if (authentication.isAuthenticated()) {
                bookService.addBook(book);
                System.out.println("livre ajouté");
                return "redirect:/library";
            } else {
                System.out.println("???");
                return "redirect:/";
            }

        }
    }
}
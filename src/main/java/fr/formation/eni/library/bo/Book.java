package fr.formation.eni.library.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private Integer idBook;
    private String title;
    private String description;
    private Integer nbPages;

    public Book(String title, String description, Integer nbPages) {
        this.title = title;
        this.description = description;
        this.nbPages = nbPages;
    }
}

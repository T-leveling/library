package fr.formation.eni.library;

import fr.formation.eni.library.bll.UtilisateurService;
import fr.formation.eni.library.bo.Utilisateur;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    @Autowired
    public UtilisateurService service;

    @PostConstruct
    public void init() {
        service.addUtilisateur(new Utilisateur("john","jojo","jojo","USER"));
        service.addUtilisateur(new Utilisateur("paul","polo","polo","ADMIN"));
        service.getAllUtilisateurs().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}

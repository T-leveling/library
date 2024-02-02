package fr.formation.eni.library.dal;

import fr.formation.eni.library.bo.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UtilisateurDAOTests {
    @Autowired
    UtilisateurDAO dao;

    @Test
    @Transactional
    void contextLoads() {
        Utilisateur utilisateur = new Utilisateur("john", "jojo", "jojo", "ADMIN");
        dao.insert(utilisateur);
    }
}

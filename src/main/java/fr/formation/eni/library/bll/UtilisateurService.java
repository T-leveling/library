package fr.formation.eni.library.bll;

import fr.formation.eni.library.bo.Utilisateur;
import fr.formation.eni.library.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UtilisateurService {

    @Autowired
    UtilisateurDAO utilisateurDAO;

    @Autowired
    PasswordEncoder encodeur;


    @Transactional
    public void addUtilisateur(Utilisateur utilisateur) {
        // encodage du mot de passe
        utilisateur.setMdp(encodeur.encode(utilisateur.getMdp()));

        // insertion en base
        utilisateurDAO.insert(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDAO.getAll();
    }

}

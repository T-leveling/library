package fr.formation.eni.library.controller;

import fr.formation.eni.library.bll.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {
    @Autowired
    public UtilisateurService service;

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("utilisateurs",service.getAllUtilisateurs());
        return "accueil";
    }
}

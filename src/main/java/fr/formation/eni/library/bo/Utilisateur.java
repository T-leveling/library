package fr.formation.eni.library.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {

    private Integer idUser;
    private String nom;
    private String pseudo;
    private String mdp;
    private String roles;

    public Utilisateur(String nom, String pseudo, String mdp, String roles) {
        this.nom = nom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.roles = roles;
    }
}

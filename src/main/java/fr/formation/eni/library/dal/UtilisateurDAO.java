package fr.formation.eni.library.dal;

import fr.formation.eni.library.bo.Utilisateur;
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
public class UtilisateurDAO {

    final String SELECT = "SELECT * FROM utilisateur";
    final String INSERT = "INSERT INTO utilisateur(nom,pseudo,mdp,roles) VALUES(:nom,:pseudo,:mdp,:roles)";
    final String SELECT_BY_PSEUDO = "SELECT * FROM utilisateur WHERE pseudo=:pseudo";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    RowMapper<Utilisateur> mapper = (rs, i) -> new Utilisateur(rs.getInt("id_user"),rs.getString("nom"), rs.getString("pseudo"),
            rs.getString("mdp"),rs.getString("roles"));


    public List<Utilisateur> getAll() {
        return jdbcTemplate.query(SELECT, mapper);
    }

    public void insert(Utilisateur utilisateur) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(utilisateur);
        namedParameterJdbcTemplate.update(INSERT, namedParameters,keyHolder);
        utilisateur.setIdUser(keyHolder.getKey().intValue());
        System.out.println("Insertion du user :" +utilisateur);
    }

    public Utilisateur findByPseudo(String pseudo) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("pseudo", pseudo);
        Utilisateur utilisateur = namedParameterJdbcTemplate.queryForObject(SELECT_BY_PSEUDO,namedParameters, new BeanPropertyRowMapper<>(Utilisateur.class));
        return utilisateur;
    }
}

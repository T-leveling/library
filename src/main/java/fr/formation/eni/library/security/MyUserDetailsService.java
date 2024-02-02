package fr.formation.eni.library.security;


import fr.formation.eni.library.bo.Utilisateur;
import fr.formation.eni.library.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Override
	public UserDetails loadUserByUsername(String pseudo) {

		Utilisateur user;
		try {
			user = utilisateurDAO.findByPseudo(pseudo);
			if (user == null) {
				throw new UsernameNotFoundException(pseudo);
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException(pseudo);
		}
		return new MyUserDetail(user);
	}
}
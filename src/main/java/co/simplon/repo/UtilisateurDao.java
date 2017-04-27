package co.simplon.repo;

import org.springframework.data.repository.CrudRepository;

import co.simplon.entity.Utilisateur;

public interface UtilisateurDao extends CrudRepository<Utilisateur, Long>{

	public Utilisateur findByUsername(String username);

}

package co.simplon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.entity.Utilisateur;
import co.simplon.repo.UtilisateurDao;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
	
	  @Autowired
	  private UtilisateurDao Dao;
	    
	  //@PreAuthorize("hasRole('ROLE_admin')")
	  //@PreAuthorize("hasRole('ROLE_apprenant')")
	  @RequestMapping(method=RequestMethod.GET)
	  public Iterable<Utilisateur> getAll() {
		    return Dao.findAll();
		  }
}

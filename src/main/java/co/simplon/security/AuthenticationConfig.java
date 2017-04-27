package co.simplon.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.simplon.entity.Role;
import co.simplon.entity.Utilisateur;
import co.simplon.repo.UtilisateurDao;

@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	UtilisateurDao dao;
	//Doit etre implmenter qu'une fois
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService());
	}
	
	@Bean
	UserDetailsService userDetailsService(){
		return new UserDetailsService() {
			
			@Transactional
			@Override
			//If we want to use any DAO class for authentication, we need to implement UserDetailsService interface. 
			//Once the DAO is configured, it’s loadUserByUsername() is used to validate the user.
			public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
				Utilisateur account = dao.findByUsername(name);
				if(account != null) {
					return new User(account.getUsername(), account.getPassword(), true, true, true, true,
							getAuthorities(account.getRoles()));
				} else {
					throw new UsernameNotFoundException ("Impossible de trouver l'utilisateur :"+ name +".");
				}
			}
		};
	}
	
	//Creation d'un collection d'autorisation a partir d'une liste de role
	public Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		String ROLE_PREFIX = "ROLE_";
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for(Role role: roles){
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getNom()));
        }
        return list;
    }
}

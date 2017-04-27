package co.simplon.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Utilisateur_Role", joinColumns = {
			@JoinColumn(name = "Utilisateur_id")},inverseJoinColumns = {@JoinColumn(name ="Role_id")
			})
	@JsonManagedReference
	private List<Role> roles;
}

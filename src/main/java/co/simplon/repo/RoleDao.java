package co.simplon.repo;

import org.springframework.data.repository.CrudRepository;

import co.simplon.entity.Role;

public interface RoleDao extends CrudRepository<Role, Long> {

}

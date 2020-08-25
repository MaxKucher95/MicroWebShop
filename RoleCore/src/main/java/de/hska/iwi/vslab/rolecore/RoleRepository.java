package de.hska.iwi.vslab.rolecore;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findById(int id);

    Role findByType(String type);

    List<Role> findAll();

    long deleteById(int id);

    long deleteByType(String type);
}
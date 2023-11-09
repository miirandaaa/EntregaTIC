package um.edu.uy.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.uy.business.entities.Usuarios;

@Repository
public interface UserRepository extends CrudRepository<Usuarios, Long> {
    Usuarios findOneByUsername(String username);
}

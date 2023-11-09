package um.edu.uy.persistence;

import org.springframework.data.repository.CrudRepository;
import um.edu.uy.business.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findOneByDocument(long document);

}

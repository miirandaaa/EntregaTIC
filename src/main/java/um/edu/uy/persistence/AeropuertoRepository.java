package um.edu.uy.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.uy.business.entities.Aeropuerto;

@Repository
public interface AeropuertoRepository extends CrudRepository<Aeropuerto, Long> {

    Aeropuerto findAeropuertoByNombreAeropuerto(String nombre);

}

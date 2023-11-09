package um.edu.uy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.edu.uy.business.entities.Aeropuerto;
import um.edu.uy.business.entities.Usuarios;
import um.edu.uy.business.exceptions.InvalidUserInformation;
import um.edu.uy.business.exceptions.UserAlreadyExists;
import um.edu.uy.persistence.AeropuertoRepository;

@Service
public class AeropuertoManager {

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public void agregarAeropuerto(Aeropuerto aeropuerto) throws InvalidUserInformation, UserAlreadyExists {

        if (aeropuerto.getNombreAeropuerto() == null || "".equals(aeropuerto.getNombreAeropuerto())
                || aeropuerto.getCiudadAeropuerto()== null || "".equals(aeropuerto.getCiudadAeropuerto())
                || aeropuerto.getPaisAeropuerto() == null || "".equals(aeropuerto.getPaisAeropuerto())) {
            throw new InvalidUserInformation("Alguno de los datos ingresados no es correcto");
        }
        // Verifico si el cliente no existe

        if (aeropuertoRepository.findAeropuertoByNombreAeropuerto(aeropuerto.getNombreAeropuerto()) != null) {
            throw new UserAlreadyExists();
        }
        aeropuertoRepository.save(aeropuerto);
    }


}

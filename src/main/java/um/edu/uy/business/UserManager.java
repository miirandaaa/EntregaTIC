package um.edu.uy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.edu.uy.business.entities.Usuarios;
import um.edu.uy.business.exceptions.InvalidUserInformation;
import um.edu.uy.business.exceptions.UserAlreadyExists;
import um.edu.uy.persistence.UserRepository;

@Service
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    public Usuarios verificarUsuario (String username, String password){
        Usuarios usuario = userRepository.findOneByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)){
            return usuario;
        }
        return null;
    }
    public void agregarUsuario(Usuarios usuario) throws InvalidUserInformation, UserAlreadyExists {

        if (usuario.getUsername() == null || "".equals(usuario.getUsername()) || usuario.getPassword() == null || "".equals(usuario.getPassword())) {
            throw new InvalidUserInformation("Alguno de los datos ingresados no es correcto");

        }
        // Verifico si el cliente no existe

        if (userRepository.findOneByUsername(usuario.getUsername()) != null) {
            throw new UserAlreadyExists();
        }
        userRepository.save(usuario);
    }
}

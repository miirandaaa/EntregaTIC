package um.edu.uy.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.uy.Main;
import um.edu.uy.business.UserManager;
import um.edu.uy.business.entities.Usuarios;
import um.edu.uy.business.exceptions.InvalidUserInformation;

import java.io.IOException;
import java.util.Objects;

@Component
public class Login {

    @Autowired
    private UserManager userMgr;

    @FXML
    private Button botonIniciarSesion;

    @FXML
    private Button botonRegistrarse;

    @FXML
    private Label loginTitle;

    @FXML
    private PasswordField password;

    @FXML
    private Label textoRegistro;

    @FXML
    private TextField user;

    @FXML
    void inicioSesion(ActionEvent event) throws InvalidUserInformation {

        if (user.getText() == null || Objects.equals(user.getText(), "") || password.getText() == null || Objects.equals(password.getText(), "")){
            //notificacion que avise que ponga algo en los campos
        } else {
            Usuarios usuarioIniciado = userMgr.verificarUsuario(user.getText(), password.getText());
            if (usuarioIniciado != null){
                pantallasSegunTipoUsuarioYRolUsuario(usuarioIniciado.userType, usuarioIniciado.userRole);
            }
            else {
                throw new InvalidUserInformation("Alguno de los datos ingresados no es correcto");
            }
        }
    }
    private void pantallasSegunTipoUsuarioYRolUsuario (String tipoUsuario, String rolUsuario){
        if ("Aeropuerto".equals(tipoUsuario)){
            if ("Administrador".equals(rolUsuario)) {
                Stage loginStage = (Stage) botonIniciarSesion.getScene().getWindow();
                loginStage.close();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setControllerFactory(Main.getContext()::getBean);
                    Parent root = fxmlLoader.load(RegistrarAeropuerto.class.getResourceAsStream("RegistrarAeropuerto.fxml"));
                    Stage registroStage = new Stage();
                    registroStage.setScene(new Scene(root));
                    registroStage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @FXML
    void toRegistro(ActionEvent event) throws Exception {
        //cierra ventana de login y lleva a ventana de registro
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(Registro.class.getResourceAsStream("registro1.fxml"));
        Stage registroStage = new Stage();
        registroStage.setScene(new Scene(root));
        registroStage.show();
    }
}

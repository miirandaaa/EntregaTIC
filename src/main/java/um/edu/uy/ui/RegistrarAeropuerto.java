package um.edu.uy.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import um.edu.uy.business.AeropuertoManager;
import um.edu.uy.business.UserManager;
import um.edu.uy.business.entities.Aeropuerto;
import um.edu.uy.business.entities.Usuarios;
import um.edu.uy.business.exceptions.InvalidUserInformation;
import um.edu.uy.business.exceptions.UserAlreadyExists;
import um.edu.uy.persistence.AeropuertoRepository;

import java.net.URL;
import java.util.ResourceBundle;


@Component
public class RegistrarAeropuerto {

    @Autowired
    private AeropuertoManager aeropuertoMgr;

    @FXML
    private Button botonRegistrarAeropuerto;

    @FXML
    private TextField ciudadAeropuerto;

    @FXML
    private TextField codigoIATA;

    @FXML
    private TextField nombreAeropuerto;

    @FXML
    private TextField numeroCheckIn;

    @FXML
    private TextField numeroGates;

    @FXML
    private AnchorPane paginaAeropuerto;

    @FXML
    private TextField paisAeropuerto;

    @FXML
    void registrarAeropuerto(ActionEvent event) {
        if (nombreAeropuerto.getText() == null || nombreAeropuerto.getText().isEmpty() ||
                ciudadAeropuerto.getText() == null || ciudadAeropuerto.getText().isEmpty() ||
                paisAeropuerto.getText() == null || paisAeropuerto.getText().isEmpty() ||
                numeroGates.getText() == null || numeroGates.getText().isEmpty() ||
                numeroCheckIn.getText() == null || numeroCheckIn.getText().isEmpty() ||
                codigoIATA.getText() == null || codigoIATA.getText().isEmpty()) {

        } else {
            try {
                String nombre = nombreAeropuerto.getText();
                String ciudad = ciudadAeropuerto.getText();
                String pais = paisAeropuerto.getText();
                String nroGates = numeroGates.getText();
                String nroCheckin = numeroCheckIn.getText();
                String codigo = codigoIATA.getText();

                try {

                    Aeropuerto aeropuerto;
                    aeropuerto = new Aeropuerto(nombre, ciudad, pais, codigo, nroCheckin, nroGates);

                    aeropuertoMgr.agregarAeropuerto(aeropuerto);

                    showAlert("Aeropuerto Registrado", "Se ha registrado con exito el Aeropuerto: "+nombre+"!");
                    close(event);

                } catch (UserAlreadyExists | InvalidUserInformation e) {
                    throw new RuntimeException(e);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    void close(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String contextText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }
}
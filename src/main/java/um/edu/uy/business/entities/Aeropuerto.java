package um.edu.uy.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    @GeneratedValue(generator="aeropuertos_ids")
    @GenericGenerator(name="aeropuertos_ids", strategy = "increment")
    public long id;

    public String nombreAeropuerto;
    public String ciudadAeropuerto;
    public String paisAeropuerto;
    public String codigoIATA;
    public String numeroGates;
    public String numeroCheckin;

    // nro puertas, nro pistas

    public Aeropuerto(String nombre, String ciudad, String pais, String codigoIATA, String numeroCheckin, String numeroGates) {
        this.nombreAeropuerto = nombre;
        this.ciudadAeropuerto = ciudad;
        this.paisAeropuerto = pais;
        this.codigoIATA = codigoIATA;
        this.numeroCheckin = numeroCheckin;
        this.numeroGates = numeroGates;
    }
    public Aeropuerto() {}

    public String getNombreAeropuerto(){return nombreAeropuerto;}
    public String getCiudadAeropuerto() {
        return ciudadAeropuerto;
    }

    public void setCiudadAeropuerto(String ciudadAeropuerto) {
        this.ciudadAeropuerto = ciudadAeropuerto;
    }

    public String getPaisAeropuerto() {
        return paisAeropuerto;
    }

    public void setPaisAeropuerto(String paisAeropuerto) {
        this.paisAeropuerto = paisAeropuerto;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getNumeroGates() {
        return numeroGates;
    }

    public void setNumeroGates(String numeroGates) {
        this.numeroGates = numeroGates;
    }

    public String getNumeroCheckin() {
        return numeroCheckin;
    }

    public void setNumeroCheckin(String numeroCheckin) {
        this.numeroCheckin = numeroCheckin;
    }


}

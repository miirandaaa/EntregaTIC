package um.edu.uy.business.entities;

public class Aerolinea {

    public long id;
    public String nombre;

    public Integer cantidadAviones;

    public Integer codigoAerolinea;


    public Aerolinea(String nombre, Integer cantidadAviones, Integer codigoAerolinea) {
        this.codigoAerolinea = codigoAerolinea;
        this.cantidadAviones = cantidadAviones;
        this.nombre = nombre;
    }
}

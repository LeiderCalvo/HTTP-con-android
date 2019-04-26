package appmoviles.com.webserviceconsumer.Modelo;

public class Vehiculo {
    public String id, marca, placa;
    public Propietario propietario;

    public Vehiculo(String id, String marca, String placa, Propietario propietario) {
        this.id = id;
        this.marca = marca;
        this.placa = placa;
        this.propietario = propietario;
    }

    public Vehiculo() {
    }
}

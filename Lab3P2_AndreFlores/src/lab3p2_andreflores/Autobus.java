package lab3p2_andreflores;

import java.awt.Color;
import java.util.Date;

public class Autobus extends Vehiculo {

    int capacidadPasajeros;
    int numEjes;
    double longitud;

    public Autobus(int capacidadPasajeros, int numEjes, double longitud, String numeroPlaca, String Marca, String Modelo, String Tipo, Color color, Date Anio) {
        super(numeroPlaca, Marca, Modelo, Tipo, color, Anio);
        this.capacidadPasajeros = capacidadPasajeros;
        this.numEjes = numEjes;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Autobus{" + "capacidadPasajeros=" + capacidadPasajeros + ", numEjes=" + numEjes + ", longitud=" + longitud + '}';
    }

}

package lab3p2_andreflores;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author andre
 */
public class Automovil extends Vehiculo {

    String tipoCombustible;
    int numPuertas;
    String tipoTransmision;
    int numAsientos;

    public Automovil(String tipoCombustible, int numPuertas, String tipoTransmision, int numAsientos, String numeroPlaca, String Marca, String Modelo, String Tipo, Color color, Date Anio) {
        super(numeroPlaca, Marca, Modelo, Tipo, color, Anio);
        this.tipoCombustible = tipoCombustible;
        this.numPuertas = numPuertas;
        this.tipoTransmision = tipoTransmision;
        this.numAsientos = numAsientos;
    }

    @Override
    public String toString() {
        return "Automovil{" + "tipoCombustible=" + tipoCombustible + ", numPuertas=" + numPuertas + ", tipoTransmision=" + tipoTransmision + ", numAsientos=" + numAsientos + '}';
    }

}

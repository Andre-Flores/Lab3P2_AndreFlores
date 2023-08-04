
package lab3p2_andreflores;

import java.awt.Color;
import java.util.Date;

public class Motocicleta extends Vehiculo {
    int velocidadMax;
    int peso;
    int consumoCombustible;

    public Motocicleta(int velocidadMax, int peso, int consumoCombustible, String numeroPlaca, String Marca, String Modelo, String Tipo, Color color, Date Anio) {
        super(numeroPlaca, Marca, Modelo, Tipo, color, Anio);
        this.velocidadMax = velocidadMax;
        this.peso = peso;
        this.consumoCombustible = consumoCombustible;
    }
    
}

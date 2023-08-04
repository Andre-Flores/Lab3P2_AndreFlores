package lab3p2_andreflores;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehiculo {

    String numeroPlaca;
    String Marca;
    String Modelo;
    String Tipo;
    Color color;
    Date Anio;

    public Vehiculo(String numeroPlaca, String Marca, String Modelo, String Tipo, Color color, Date Anio) {
        this.numeroPlaca = numeroPlaca;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Tipo = Tipo;
        this.color = color;
        this.Anio = Anio;
    }

    public String getAnio() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(Anio);
    }

}

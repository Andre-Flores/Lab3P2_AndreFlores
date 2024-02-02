package lab3p2_andrefloresr;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Pokemon {

    protected String nombre;
    protected int numPokedex;
    protected String naturaleza;
    protected boolean atrapado;
    protected pokeBall pokebola;

    public Pokemon(String nombre, int numPokedex, String naturaleza, boolean atrapado, pokeBall pokebola) {
        this.nombre = nombre;
        this.numPokedex = numPokedex;
        this.naturaleza = naturaleza;
        this.atrapado = atrapado;
        this.pokebola = pokebola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        Scanner entrada = new Scanner(System.in);
        while (!validarNaturaleza(naturaleza)) {
            System.out.println("ingrese la naturaleza bien: (timido, energetico o misterioso.");
            naturaleza = entrada.nextLine();
        }
        this.naturaleza = naturaleza;

    }

    protected boolean validarNaturaleza(String naturaleza) {
        return naturaleza.equalsIgnoreCase("timido") || naturaleza.equalsIgnoreCase("energetico") || naturaleza.equalsIgnoreCase("misterioso");
    }

    public boolean isAtrapado() {
        return atrapado;
    }

    public void setAtrapado(boolean atrapado) {
        this.atrapado = atrapado;
    }

    public void metAtrapar(pokeBall pokebola) {
        atrapado = true;
        this.pokebola = pokebola;
    }

    public pokeBall getPokebola() {
        return pokebola;
    }

    public void setPokebola(pokeBall pokebola) {
        this.pokebola = pokebola;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", numPokedex=" + numPokedex + ", naturaleza=" + naturaleza + ", atrapado=" + atrapado + ", pokebola=" + pokebola + '}';
    }

}

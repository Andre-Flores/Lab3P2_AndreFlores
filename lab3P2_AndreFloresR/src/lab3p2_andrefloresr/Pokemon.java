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

    public Pokemon(String nombre, int numPokedex, String naturaleza, boolean atrapado) {
        this.nombre = nombre;
        this.numPokedex = numPokedex;
        this.naturaleza = naturaleza;
        this.atrapado = atrapado;
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
        this.naturaleza = naturaleza;
    }


    public boolean isAtrapado() {
        return atrapado;
    }

    public void setAtrapado(boolean atrapado) {
        this.atrapado = atrapado;
    }

    public void metAtrapar(pokeBall pokebola) {
        atrapado = false;
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
        return "Pokemon:" + "nombre=" + nombre + ", numPokedex=" + numPokedex + ", naturaleza=" + naturaleza + ", atrapado=" + atrapado + ", pokebola=" + pokebola + '}';
    }
    

}

package lab3p2_andrefloresr;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class grassType extends Pokemon {

    private String habitat;
    private int dominioPlantas;

    public grassType(String nombre, int numPokedex, String naturaleza, boolean atrapado) {
        super(nombre, numPokedex, naturaleza, atrapado = false);
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getDominioPlantas() {
        return dominioPlantas;
    }

    public void setDominioPlantas(int dominioPlantas) {
        this.dominioPlantas = dominioPlantas;
    }

    @Override
    public String toString() {
        return super.toString() + "grassType{" + "habitat=" + habitat + ", dominioPlantas=" + dominioPlantas + '}';
    }

}

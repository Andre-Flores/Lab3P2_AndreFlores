package lab3p2_andrefloresr;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class grassType extends Pokemon {

    String habitat;
    int dominioPlantas;

    public grassType(String nombre, int numPokedex, String naturaleza, boolean atrapado, pokeBall pokebola) {
        super(nombre, numPokedex, naturaleza, atrapado, pokebola);
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
        Scanner entrada = new Scanner(System.in);
        while (dominioPlantas <= 0 || dominioPlantas >= 100) {
            System.out.println("numero invalido, ingrese un numero entre 0 y 100.");
            dominioPlantas = entrada.nextInt();
        }
        this.dominioPlantas = dominioPlantas;
    }

    @Override
    public String toString() {
        return "grassType{" + "habitat=" + habitat + ", dominioPlantas=" + dominioPlantas + '}';
    }

}

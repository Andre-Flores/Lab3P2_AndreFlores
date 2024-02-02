package lab3p2_andrefloresr;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class pokeBall {

    private String color;
    private int numSerie;
    private int rateAtrapar;

    public pokeBall(String color, int numSerie, int rateAtrapar) {
        this.color = color;
        this.numSerie = numSerie;
        this.rateAtrapar = rateAtrapar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public int getRateAtrapar() {
        return rateAtrapar;
    }

    public void setRateAtrapar(int rateAtrapar) {
        Scanner entrada = new Scanner(System.in);
        while (!validarRateAtrapar(rateAtrapar)) {
            System.out.println("escriba un numero entre 1 y 3");
            rateAtrapar = entrada.nextInt();
        }

        this.rateAtrapar = rateAtrapar;
    }

    private boolean validarRateAtrapar(int rateAtrapar) {
        return rateAtrapar >= 1 && rateAtrapar <= 3;
    }
}

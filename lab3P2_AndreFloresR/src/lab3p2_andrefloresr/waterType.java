package lab3p2_andrefloresr;

/**
 *
 * @author andre
 */
public class waterType extends Pokemon {

    private boolean vivirFuera;
    private int rapidezNadar;

    public waterType(boolean vivirFuera, int rapidezNadar, String nombre, int numPokedex, String naturaleza, boolean atrapado) {
        super(nombre, numPokedex, naturaleza, atrapado = false);
        this.vivirFuera = vivirFuera;
        this.rapidezNadar = rapidezNadar;
    }

    public boolean isVivirFuera() {
        return vivirFuera;
    }

    public void setVivirFuera(boolean vivirFuera) {
        this.vivirFuera = vivirFuera;
    }

    public int getRapidezNadar() {
        return rapidezNadar;
    }

    public void setRapidezNadar(int rapidezNadar) {
        this.rapidezNadar = rapidezNadar;
    }

    @Override
    public String toString() {
        return super.toString()+"waterType{" + "vivirFuera=" + vivirFuera + ", rapidezNadar=" + rapidezNadar + '}';
    }

}

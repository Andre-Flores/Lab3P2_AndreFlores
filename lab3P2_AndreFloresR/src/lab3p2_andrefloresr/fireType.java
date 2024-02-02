package lab3p2_andrefloresr;

/**
 *
 * @author andre
 */
public class fireType extends Pokemon {

    int potenciaLlamas;

    public fireType(int potenciaLlamas, String nombre, int numPokedex, String naturaleza, boolean atrapado, pokeBall pokebola) {
        super(nombre, numPokedex, naturaleza, atrapado, pokebola);
        this.potenciaLlamas = potenciaLlamas;
    }

    public int getPotenciaLlamas() {
        return potenciaLlamas;
    }

    public void setPotenciaLlamas(int potenciaLlamas) {
        this.potenciaLlamas = potenciaLlamas;
    }

    @Override
    public String toString() {
        return "fireType{" + "potenciaLlamas=" + potenciaLlamas + '}';
    }

}

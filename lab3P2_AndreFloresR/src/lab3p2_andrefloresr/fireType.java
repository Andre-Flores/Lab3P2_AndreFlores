package lab3p2_andrefloresr;

/**
 *
 * @author andre
 */
public class fireType extends Pokemon {

    private int potenciaLlamas;

    public fireType(int potenciaLlamas, String nombre, int numPokedex, String naturaleza, boolean atrapado) {
        super(nombre, numPokedex, naturaleza, atrapado = false);
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
        return super.toString()+"fireType{" + "potenciaLlamas=" + potenciaLlamas + '}';
    }

}

package lab3p2_andrefloresr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Lab3P2_AndreFloresR {

    public static void main(String[] args) {
        int op = 0;
        Scanner entrada = new Scanner(System.in);
        ArrayList<Pokemon> listaPokemon = new ArrayList();
        ArrayList<pokeBall> listaPokebolas = new ArrayList();
        do {
            System.out.println("1-crear Pokemon");
            System.out.println("2-crear pokebola");
            System.out.println("3-Listar pokemon");
            System.out.println("4-eliminar pokemon");
            System.out.println("5- capturar pokemon");
            System.out.println("6- modificar pokemon");
            System.out.println("7- salir");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    crearPokemon(entrada, listaPokemon);
                    break;
                case 2:
                    crearPokeball(entrada, listaPokebolas);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("saliendo");
                    break;

                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (op != 7);
    }

    private static void crearPokemon(Scanner entrada, ArrayList<Pokemon> listaPokemon) {
        System.out.println("ingrese el nombre del pokemon");
        entrada.next();
        String nombre = entrada.nextLine();
        System.out.println("ingrese el numero de entrada en la pokedex");
        int numPokedex = entrada.nextInt();
        String naturaleza;
        while (true) {
            System.out.println("Ingrese la naturaleza del Pokemon (timido, energetico, misterioso):");
            entrada.nextLine();
            naturaleza = entrada.nextLine().toLowerCase();

            if (isValidNaturaleza(naturaleza)) {
                break;
            } else {
                System.out.println("Naturaleza no valida. Intente de nuevo.");
            }
        }

        System.out.println("Seleccione el tipo de Pokemon:");
        System.out.println("1: FireType");
        System.out.println("2: WaterType");
        System.out.println("3: GrassType");
        int tipoPokemon = entrada.nextInt();
        Pokemon nuevoPokemon = null;
        switch (tipoPokemon) {
            case 1:
                System.out.print("Ingrese la potencia de las llamas del Pokemon FireType: ");
                int potenciaLlamas = entrada.nextInt();
                nuevoPokemon = new fireType(potenciaLlamas, nombre, numPokedex, naturaleza, false);
                break;
            case 2:
                System.out.print("¿Puede vivir fuera del agua? (true/false): ");
                boolean puedeVivirFueraAgua = entrada.nextBoolean();
                System.out.print("Ingrese la rapidez al nadar del Pokemon WaterType: ");
                int rapidezNadar = entrada.nextInt();
                nuevoPokemon = new waterType(puedeVivirFueraAgua, rapidezNadar, nombre, numPokedex, naturaleza, false);
                break;
            case 3:
                System.out.print("Ingrese el habitat del Pokemon GrassType: ");
                String habitat = entrada.next();
                System.out.print("Ingrese el dominio sobre plantas del Pokemon GrassType (entre 0 y 100): ");
                int dominioSobrePlantas = entrada.nextInt();
                nuevoPokemon = new grassType(nombre, numPokedex, naturaleza, false);
                break;
            default:
                System.out.println("Tipo de Pokemon no valido.");
                return;
        }
        listaPokemon.add(nuevoPokemon);
        System.out.println("Pokemon creado y agregado a la lista exitosamente.");
    }

    private static boolean isValidNaturaleza(String naturaleza) {
        return naturaleza.equalsIgnoreCase("timido") || naturaleza.equalsIgnoreCase("energetico") || naturaleza.equalsIgnoreCase("misterioso");
    }

    private static void crearPokeball(Scanner entrada, ArrayList<pokeBall> listaPokebolas) {
        System.out.println("ingrese el color");
        entrada.next();
        String color = entrada.nextLine();
        System.out.println("ingrese el numero de serie");
        int numSerie = entrada.nextInt();
        int rateAtrapar;
        while (true) {
            System.out.println("Ingrese la eficiencia de atrapado de la Pokebola (entre 1 y 3):");
            rateAtrapar = entrada.nextInt();

            if (validarRateAtrapar(rateAtrapar)) {
                break;
            } else {
                System.out.println("Valor no valido. Intente de nuevo.");
            }
        }

        pokeBall nuevaPokebola = new pokeBall(color, numSerie, rateAtrapar);
        listaPokebolas.add(nuevaPokebola);

        System.out.println("Pokebola creada y agregada a la lista exitosamente.");
    }

    private static boolean validarRateAtrapar(int rateAtrapar) {
        return rateAtrapar >= 1 && rateAtrapar <= 3;
    }
}

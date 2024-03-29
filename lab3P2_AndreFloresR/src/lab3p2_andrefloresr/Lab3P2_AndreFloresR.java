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
                    listarPokemon(listaPokemon);
                    break;
                case 4:
                    eliminarPokemon(entrada, listaPokemon);
                    break;
                case 5:
                    capturarPokemon(entrada, listaPokemon, listaPokebolas);
                    break;
                case 6:
                    modificarPokemon(entrada, listaPokemon);
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
        entrada.nextLine();
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
                System.out.print("Puede vivir fuera del agua? (true/false): ");
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
        entrada.nextLine();
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

    private static void listarPokemon(ArrayList<Pokemon> listaPokemon) {
        if (listaPokemon.isEmpty()) {
            System.out.println("No hay Pokemon en la lista.");
        } else {
            System.out.println("Lista de Pokemon:");
            for (Pokemon pokemon : listaPokemon) {
                System.out.println(pokemon);
            }
        }
    }

    private static void eliminarPokemon(Scanner entrada, ArrayList<Pokemon> listaPokemon) {
        System.out.println("Seleccione el tipo de Pokemon que desea eliminar:");
        System.out.println("1: FireType");
        System.out.println("2: WaterType");
        System.out.println("3: GrassType");
        int tipoPokemon = entrada.nextInt();

        ArrayList<Pokemon> pokemonTipoElegido = new ArrayList<>();

        switch (tipoPokemon) {
            case 1:
                pokemonTipoElegido = obtenerPokemonPorTipo(listaPokemon, "fire");
                break;
            case 2:
                pokemonTipoElegido = obtenerPokemonPorTipo(listaPokemon, "water");
                break;
            case 3:
                pokemonTipoElegido = obtenerPokemonPorTipo(listaPokemon, "grass");
                break;
            default:
                System.out.println("Tipo de Pokemon no valido.");
                return;
        }

        if (pokemonTipoElegido.isEmpty()) {
            System.out.println("No hay Pokemon del tipo seleccionado para eliminar.");
        } else {
            System.out.println("Lista de Pokemon del tipo seleccionado:");
            for (int i = 0; i < pokemonTipoElegido.size(); i++) {
                System.out.println(i + ": " + pokemonTipoElegido.get(i));
            }

            System.out.println("Seleccione el indice del Pokemon que desea eliminar:");
            int indiceEliminar = entrada.nextInt();

            if (indiceEliminar >= 0 && indiceEliminar < pokemonTipoElegido.size()) {
                Pokemon pokemonEliminar = pokemonTipoElegido.get(indiceEliminar);
                listaPokemon.remove(pokemonEliminar);
                System.out.println("Pokemon eliminado exitosamente.");
            } else {
                System.out.println("indice no valido. No se elimino ningun Pokemon.");
            }
        }
    }

    private static ArrayList<Pokemon> obtenerPokemonPorTipo(ArrayList<Pokemon> listaPokemon, String tipo) {
        ArrayList<Pokemon> pokemonTipoElegido = new ArrayList<>();
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon instanceof fireType && tipo.equals("fire")) {
                pokemonTipoElegido.add(pokemon);
            } else if (pokemon instanceof waterType && tipo.equals("water")) {
                pokemonTipoElegido.add(pokemon);
            } else if (pokemon instanceof grassType && tipo.equals("grass")) {
                pokemonTipoElegido.add(pokemon);
            }
        }
        return pokemonTipoElegido;
    }

    private static void capturarPokemon(Scanner entrada, ArrayList<Pokemon> listaPokemon, ArrayList<pokeBall> listaPokebolas) {
        if (listaPokebolas.isEmpty()) {
            System.out.println("No hay Pokebolas disponibles para capturar Pokemon.");
            return;
        }

        System.out.println("Seleccione una Pokebola para intentar capturar un Pokemon:");
        for (int i = 0; i < listaPokebolas.size(); i++) {
            System.out.println(i + ": " + listaPokebolas.get(i));
        }

        int indicePokebola = entrada.nextInt();

        if (indicePokebola < 0 || indicePokebola >= listaPokebolas.size()) {
            System.out.println("Indice de Pokebola no valido.");
            return;
        }

        pokeBall pokebolaElegida = listaPokebolas.get(indicePokebola);

        if (pokebolaElegida.getRateAtrapar() == 0) {
            System.out.println("La eficiencia de atrapado de la Pokebola seleccionada es 0. No se puede utilizar.");
            return;
        }

        ArrayList<Pokemon> pokemonNoAtrapados = obtenerPokemonNoAtrapados(listaPokemon);

        if (pokemonNoAtrapados.isEmpty()) {
            System.out.println("No hay Pokemon disponibles para capturar.");
            return;
        }

        Pokemon pokemonAtrapar = pokemonNoAtrapados.get((int) (Math.random() * pokemonNoAtrapados.size()));

        System.out.println("Un Pokemon ha aparecido: " + pokemonAtrapar.getNombre());
        System.out.println("Desea utilizar la Pokebola para intentar capturarlo? (1: Si / 2: Huir)");

        int opcionCaptura = entrada.nextInt();

        if (opcionCaptura == 1) {
            double chanceAtrapar = (double) pokebolaElegida.getRateAtrapar() / 3;

            if (Math.random() < chanceAtrapar) {
                System.out.println("El Pokemon " + pokemonAtrapar.getNombre() + " ha sido capturado.");
                pokemonAtrapar.setAtrapado(true);
                pokemonAtrapar.setPokebola(pokebolaElegida);
                listaPokebolas.remove(pokebolaElegida);
            } else {
                System.out.println("No se pudo atrapar al Pokemon " + pokemonAtrapar.getNombre() + ".");
                listaPokebolas.remove(pokebolaElegida);
            }
        } else {
            System.out.println("Has huido del encuentro.");
        }
    }

    private static ArrayList<Pokemon> obtenerPokemonNoAtrapados(ArrayList<Pokemon> listaPokemon) {
        ArrayList<Pokemon> pokemonNoAtrapados = new ArrayList<>();
        for (Pokemon pokemon : listaPokemon) {
            if (!pokemon.isAtrapado()) {
                pokemonNoAtrapados.add(pokemon);
            }
        }
        return pokemonNoAtrapados;
    }

    private static void modificarPokemon(Scanner entrada, ArrayList<Pokemon> listaPokemon) {
        System.out.println("Seleccione el tipo de Pokemon que desea modificar:");
        System.out.println("1: FireType");
        System.out.println("2: WaterType");
        System.out.println("3: GrassType");
        int tipoPokemon = entrada.nextInt();
        ArrayList<Pokemon> pokemonTipoElegido = new ArrayList<>();
        switch (tipoPokemon) {
            case 1:
                pokemonTipoElegido = obtenerPokemonAtrapadosPorTipo(listaPokemon, "fire");
                break;
            case 2:
                pokemonTipoElegido = obtenerPokemonAtrapadosPorTipo(listaPokemon, "water");
                break;
            case 3:
                pokemonTipoElegido = obtenerPokemonAtrapadosPorTipo(listaPokemon, "grass");
                break;
            default:
                System.out.println("Tipo de Pokemon no valido.");
                return;
        }
        if (pokemonTipoElegido.isEmpty()) {
            System.out.println("No hay Pokemon del tipo seleccionado para modificar.");
        } else {
            System.out.println("Lista de Pokemon del tipo seleccionado:");
            for (int i = 0; i < pokemonTipoElegido.size(); i++) {
                System.out.println(i + ": " + pokemonTipoElegido.get(i));
            }
            System.out.println("Seleccione el indice del Pokemon a modificar:");
            int indiceModificar = entrada.nextInt();
            if (indiceModificar >= 0 && indiceModificar < pokemonTipoElegido.size()) {
                Pokemon pokemonModificar = pokemonTipoElegido.get(indiceModificar);
                System.out.println("Seleccione que quiere modificar:");
                System.out.println("1: Nombre");
                System.out.println("2: Numero de Entrada en la pokedex.");
                if (pokemonModificar instanceof fireType) {
                    System.out.println("3: Potencia de llamas.");
                } else if (pokemonModificar instanceof waterType) {
                    System.out.println("3: Puede vivir fuera del agua.");
                } else if (pokemonModificar instanceof grassType) {
                    System.out.println("3: Habitat.");
                }
                int atributoModificar = entrada.nextInt();
                switch (atributoModificar) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre del Pokemon:");
                        entrada.nextLine();
                        String nuevoNombre = entrada.nextLine();
                        pokemonModificar.setNombre(nuevoNombre);
                        System.out.println("Nombre modificado.");
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo numero de entrada en la pokedex:");
                        int nuevoNumPokedex = entrada.nextInt();
                        pokemonModificar.setNumPokedex(nuevoNumPokedex);
                        System.out.println("Numero de Entrada en la pokedex modificado.");
                        break;
                    case 3:
                        if (pokemonModificar instanceof fireType) {
                            System.out.println("Ingrese la nueva potencia de llamas del Pokemon FireType:");
                            int nuevapotenciaLlamas = entrada.nextInt();
                            ((fireType) pokemonModificar).setPotenciaLlamas(nuevapotenciaLlamas);
                            System.out.println("Potencia de llamas modificada.");
                        } else if (pokemonModificar instanceof waterType) {
                            System.out.println("Ingrese si el Pokemon WaterType puede vivir fuera del agua (true/false):");
                            boolean nuevoVivirFuera = entrada.nextBoolean();
                            ((waterType) pokemonModificar).setVivirFuera(nuevoVivirFuera);
                            System.out.println("Puede vivir fuera del agua modificado.");
                        } else if (pokemonModificar instanceof grassType) {
                            System.out.println("Ingrese el nuevo habitat del Pokemon GrassType:");
                            entrada.nextLine();
                            String nuevoHabitat = entrada.nextLine();
                            ((grassType) pokemonModificar).setHabitat(nuevoHabitat);
                            System.out.println("Habitat modificado.");
                        }
                        break;
                    default:
                        System.out.println("Atributo no valido. No se modifico nada.");
                        break;
                }
            } else {
                System.out.println("Indice no valido. No pudo nada.");
            }
        }
    }

    private static ArrayList<Pokemon> obtenerPokemonAtrapadosPorTipo(ArrayList<Pokemon> listaPokemon, String tipo) {
        ArrayList<Pokemon> pokemonTipoElegido = new ArrayList<>();
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon.isAtrapado() && ((pokemon instanceof fireType && tipo.equals("fire"))
                    || (pokemon instanceof waterType && tipo.equals("water"))
                    || (pokemon instanceof grassType && tipo.equals("grass")))) {
                pokemonTipoElegido.add(pokemon);
            }
        }
        return pokemonTipoElegido; 
    }
}

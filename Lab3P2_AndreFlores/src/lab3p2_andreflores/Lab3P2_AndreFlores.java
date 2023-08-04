package lab3p2_andreflores;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3P2_AndreFlores {

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Agregar automovil");
            System.out.println("2. Agregar motocicleta");
            System.out.println("3. Agregar autobus");
            System.out.println("4. modificar vehiculo");
            System.out.println("5. eliminar vehiculo");
            System.out.println("6. mostrar vehiculos");
            System.out.println("7. generar boleta");
            System.out.println("8. Salir");
            System.out.println(" Escoja una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("1. Agregar automovil");
                    break;
                case 2:
                    System.out.println("2. Agregar motocicleta");
                    break;
                case 3:
                     System.out.println("3. Agregar autobus");
                    break;
                case 4:
                    System.out.println("4. modificar vehiculo");
                    break;
                case 5:
                    System.out.println("5. eliminar vehiculo");
                    break;
                case 6:
                    System.out.println("6. mostrar vehiculos");
                    break;
                case 7:
                    System.out.println("7. generar boleta");
                    break;
                case 8:
                    System.out.println("Gracias por utilizar el programa.");
                    break;

                default:
                    System.out.println("opcion invalida, ingrese otra vez.");
                    break;
            }
        } while (opcion != 8);
    }

}

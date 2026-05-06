import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int opcion; // es la variable para guardar la opción del menu

        int[] arreglo = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3};

        do { //  ---> un bucle do while para que el programa se mantenga activo hasta salir
            System.out.println("\n==== PROGRAMA DE ORDENAMIENTO ====");
            System.out.println("1. Ejecutar ordenamientos");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = lector.nextInt();

            if (opcion == 1) {

                System.out.print("Inserción ascendente? true/false: ");
                boolean esAscendenteInsercion = lector.nextBoolean();

                System.out.print("Shell ascendente? true/false: ");
                boolean esAscendenteShell = lector.nextBoolean();

                Resultado resultadoInsercion =
                        Insercion.ejecutar(arreglo, esAscendenteInsercion);

                Resultado resultadoShell =
                        Shell.ejecutar(arreglo, esAscendenteShell);

            }

        } while (opcion != 2);

        lector.close(); // .close --- > cierra el programa 
    }
}
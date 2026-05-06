public class Shell {

    public static Resultado ejecutar(int[] original, boolean ascendente) {

        int[] datos = original.clone();
        Resultado resultado = new Resultado();
        int paso = 1;

        mostrarInicio("SHELL", datos);

        int salto = datos.length / 2; // Se define el salto inicial (gap)

        while (salto > 0) {  // Mientras el salto sea mayor a 0

            for (int i = salto; i < datos.length; i++) { // Se recorre el arreglo desde la posición del salto

                int actual = datos[i];
                int indice = i;

                while (indice >= salto) {

                    resultado.iteraciones++;
                    resultado.comparaciones++; // Se cuenta cada iteración y comparación

                    if (comparar(datos[indice - salto], actual, ascendente)) {

                        imprimirPaso(paso++, datos, indice - salto, indice,datos[indice - salto], actual, salto, true);

                        datos[indice] = datos[indice - salto];
                        resultado.cambios++;

                        mostrarArreglo(datos);

                        indice -= salto;

                    } else {

                        imprimirPaso(paso++, datos, indice - salto, indice, datos[indice - salto], actual, salto, false);
                        break;
                    }
                }

                datos[indice] = actual;
            }

            salto /= 2;
        }

        resultado.arregloFinal = datos;
        mostrarFin(datos, resultado);
        return resultado;
    }

    private static boolean comparar(int a, int b, boolean asc) {
        return asc ? a > b : a < b;
    }

    private static void mostrarInicio(String nombre, int[] arreglo) {
        System.out.println("\n==== METODO " + nombre + " ====");
        System.out.println("Arreglo original:");
        mostrarArreglo(arreglo);
    }

    private static void mostrarFin(int[] arreglo, Resultado r) {
        System.out.println("end");

        System.out.println("Arreglo ordenado:");
        mostrarArreglo(arreglo);

        System.out.println("COMPARACIONES = " + r.comparaciones);
        System.out.println("ITERACIONES   = " + r.iteraciones);
        System.out.println("CAMBIOS       = " + r.cambios);
    }

    private static void imprimirPaso(int paso, int[] arreglo,int a, int b,int valorA, int valorB,int gap, boolean cambio) {

        System.out.printf("%-4s", "I" + paso);

        for (int n : arreglo) {
            System.out.printf("%6d", n);
        }

        System.out.printf("   gap=%-3d", gap); // Se muestra el valor del salto (gap)
        System.out.printf("   a=%d b=%d", a, b); // Se muestran los índices comparados
        System.out.printf("   [a]=%d [b]=%d", valorA, valorB);// Se muestran los valores comparados
        System.out.printf("   cambio=%s\n", cambio ? "si" : "no"); // Indica si hubo cambio o no
    }

    private static void mostrarArreglo(int[] arreglo) {
        for (int n : arreglo) {
            System.out.printf("%6d", n); // Muestra el arreglo en formato alineado
        }
        System.out.println();
    }
}
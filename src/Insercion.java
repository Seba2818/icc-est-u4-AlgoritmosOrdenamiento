public class Insercion {

    public static Resultado ejecutar(int[] original, boolean ascendente) { // Metodo principal que ejecuta el algoritmo de insercion

        int[] datos = original.clone();
        Resultado resultado = new Resultado();
        int paso = 1;

        mostrarInicio("INSERCIÓN", datos);

        for (int i = 1; i < datos.length; i++) {

            resultado.iteraciones++;
            int actual = datos[i];
            int indice = i - 1;

            while (indice >= 0) {

                resultado.comparaciones++;

                if (comparar(datos[indice], actual, ascendente)) {

                    imprimirPaso(paso++, datos, indice, indice + 1, datos[indice], actual, true);

                    datos[indice + 1] = datos[indice];
                    resultado.cambios++;

                    mostrarArreglo(datos);

                    indice--;

                } else {

                    imprimirPaso(paso++, datos, indice, indice + 1, datos[indice], actual, false);
                    break;
                }
            }

            datos[indice + 1] = actual; // aqui se inserta el valor en la posicion correcta
        }

        resultado.arregloFinal = datos; // se guarda el arreglo final ordenado en el resultado
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

    private static void imprimirPaso(int paso, int[] arreglo, int a, int b, int valorA, int valorB, boolean cambio) {

        System.out.printf("%-4s", "I" + paso);

        for (int n : arreglo) {
            // %6d se usa para imprimir cada número ocupando 6 espacios,
            // esto sirve para que todos los valores queden alineados en columnas
            
            System.out.printf("%6d", n);
        }

        System.out.printf("   a=%d b=%d [a]=%d [b]=%d cambio=%s\n", a, b, valorA, valorB, cambio ? "si" : "no");
    }

    private static void mostrarArreglo(int[] arreglo) {
        for (int n : arreglo) {
            System.out.printf("%6d", n);
        }
        System.out.println();
    }
}
public class Resultado {

    public int comparaciones;
    public int cambios;
    public int iteraciones;
    public int[] arregloFinal;

    public Resultado() {
        comparaciones = 0;
        cambios = 0;
        iteraciones = 0;
    }

    public void mostrar() {
        System.out.println("Arreglo ordenado:");
        for (int n : arregloFinal) {
            System.out.printf("%6d", n);
        }
        System.out.println();

        System.out.println("COMPARACIONES = " + comparaciones);
        System.out.println("ITERACIONES   = " + iteraciones);
        System.out.println("CAMBIOS       = " + cambios);
    }
}
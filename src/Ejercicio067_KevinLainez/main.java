package Ejercicio067_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 067 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #67: Lanzamiento de Monedas (Ejercicio 6.34 Libro 1)
 * * PROMPT:
 * Escriba un programa que simule el lanzamiento de monedas. Cada vez que se
 * lance la moneda, el programa debe imprimir Cara o Cruz. Deje que el programa
 * lance la moneda 100 veces y cuente el número de veces que aparezca cada uno
 * de los lados de la moneda. Imprima los resultados. El programa debe llamar
 * a un método separado, llamado tirar, que no reciba argumentos y devuelva 0
 * en caso de cara y 1 en caso de cruz.
 */
public class main {

    private static final int NUMERO_LANZAMIENTOS = 100;

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo(NUMERO_LANZAMIENTOS);

        int contadorCaras = 0;
        int contadorCruces = 0;

        // 2. Mostrar encabezado de simulación
        utilidades.mostrarEncabezadoSimulacion();

        // 3. Bucle para simular 100 lanzamientos
        for (int i = 1; i <= NUMERO_LANZAMIENTOS; i++) {

            // Llamada al método requerido: tirar()
            int resultado = operaciones.tirar();
            String nombreLado = operaciones.obtenerNombreLado(resultado);

            // Contar el resultado
            if (resultado == operaciones.CARA) {
                contadorCaras++;
            } else {
                contadorCruces++;
            }

            // Imprimir el resultado (maneja su propio formato de columna)
            utilidades.imprimirLanzamiento(i, nombreLado);
        }

        // Cierre de la sección de simulación (si no terminó en un salto de línea)
        System.out.println();
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        // 4. Mostrar Totales
        utilidades.mostrarTotales(NUMERO_LANZAMIENTOS, contadorCaras, contadorCruces);

        // 5. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}
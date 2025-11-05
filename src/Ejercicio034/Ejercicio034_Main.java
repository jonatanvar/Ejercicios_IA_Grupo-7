package Ejercicio034;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 034 | 2025-10-15
 */
public class Ejercicio034_Main {

    private static final int MSG_PRODUCTO = 11;
    private static final int MSG_FINALIZACION = 17;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello Personalizado
        Ejercicio034_Utilidades.mostrarSelloCorto();

        // 2. Selección de Idioma
        Ejercicio034_Utilidades.seleccionarIdioma(scanner);

        // 3. Menú de Ejecución (bucle para repetición)
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio034_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio034_Utilidades.mostrarEncabezado();

            double totalVentas = 0.0;
            int centinela = Ejercicio034_Utilidades.getCentinela();

            // 4. Ciclo controlado por centinela (pregunta antes de entrar)
            int numeroProducto = Ejercicio034_Utilidades.leerEntero(scanner, Ejercicio034_Utilidades.obtenerTexto(MSG_PRODUCTO));

            while (numeroProducto != centinela) {

                // 5. Determinar el precio usando switch (en la clase Operaciones)
                double precioUnitario = Ejercicio034_Operaciones.obtenerPrecio(numeroProducto);

                if (precioUnitario > 0.0) {
                    // Si el producto es válido (1-5), leer la cantidad y sumar a las ventas
                    int cantidadVendida = Ejercicio034_Utilidades.leerCantidadVendida(scanner);

                    totalVentas += (precioUnitario * cantidadVendida);

                } else {
                    // Producto inválido (si el usuario ingresó un número distinto de 0 y fuera de 1-5)
                    Ejercicio034_Utilidades.mostrarErrorProductoInvalido();
                }

                System.out.println();
                // Preguntar por el siguiente producto (Actualización del centinela)
                numeroProducto = Ejercicio034_Utilidades.leerEntero(scanner, Ejercicio034_Utilidades.obtenerTexto(MSG_PRODUCTO));
            }

            // 6. Mostrar resultado final
            Ejercicio034_Utilidades.mostrarResultado(totalVentas);

            System.out.println(); // Separador antes de volver al menú de ejecución
        }

        // 7. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio034_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}
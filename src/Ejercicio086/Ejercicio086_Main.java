package Ejercicio086;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 086 | 2025-10-16
 */
public class Ejercicio086_Main {

    private static final int MSG_FINALIZACION = 13;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello y Seleccionar Idioma
        Ejercicio086_Utilidades.mostrarSelloCorto();
        Ejercicio086_Utilidades.seleccionarIdioma(scanner);

        // 2. Menú de Ejecución
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio086_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio086_Utilidades.mostrarEncabezado();

            // 3. Leer el mensaje del usuario
            String mensaje = Ejercicio086_Utilidades.leerMensaje(scanner);

            // 4. Llamar a la función de la LIBRERÍA PROPIA para guardar el archivo
            boolean exito = ManejadorArchivos.escribirLinea(mensaje);

            // 5. Mostrar el resultado
            if (exito) {
                Ejercicio086_Utilidades.mostrarExito(ManejadorArchivos.getNombreArchivo());
            }
            // Si hay error, ManejadorArchivos ya mostró un mensaje de error por consola.

            System.out.println();
        }

        // 6. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio086_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}
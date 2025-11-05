package Ejercicio068;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 068 | 2025-10-16
 */
public class Ejercicio068_Main {

    private static final int MSG_PREGUNTA = 11;
    private static final int MSG_CORRECTO = 12;
    private static final int MSG_INCORRECTO = 13;
    private static final int MSG_FINALIZACION = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello Personalizado
        Ejercicio068_Utilidades.mostrarSelloCorto();

        // 2. Selección de Idioma
        Ejercicio068_Utilidades.seleccionarIdioma(scanner);

        // 3. Menú de Ejecución (bucle para repetición del programa completo)
        boolean ejecutarPrograma = true;
        while (ejecutarPrograma) {
            if (!Ejercicio068_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutarPrograma = false;
                break;
            }

            // --- INICIO DEL TUTOR (Bucle interno para múltiples preguntas) ---
            Ejercicio068_Utilidades.mostrarEncabezado();

            boolean continuarPreguntando = true;

            while (continuarPreguntando) {

                // 4. Llamada a la función: Hace la pregunta, lee y valida la respuesta
                Ejercicio068_Funciones.hacerPregunta(
                        scanner,
                        Ejercicio068_Utilidades.obtenerTexto(MSG_PREGUNTA),
                        Ejercicio068_Utilidades.obtenerTexto(MSG_CORRECTO),
                        Ejercicio068_Utilidades.obtenerTexto(MSG_INCORRECTO)
                );

                // 5. Preguntar si desea otra pregunta
                continuarPreguntando = Ejercicio068_Utilidades.preguntarContinuar(scanner);
                scanner.nextLine(); // Consumir el resto de la línea después de S/N
            }

            System.out.println(); // Separador antes de volver al menú de ejecución
        }

        // 6. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio068_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}
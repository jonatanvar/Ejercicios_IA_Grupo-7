package Ejercicio043_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 043 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #43: Menú Interactivo Modular
 * * PROMPT:
 * Vamos a hacer un programa que muestre un menú llamando a una función que
 * presenta las opciones al usuario y devuelve la opción elegida. Validar la
 * entrada de opciones válidas. No se puede mostrar o validar nada desde el main.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // Bucle principal del programa
        do {
            // 3. Llamada a la función que gestiona y valida TODO el menú.
            // Esta línea es la única que interactúa con la lógica del menú/usuario.
            opcion = operaciones.gestionarMenu(sc);

            // 4. Actuar sobre la opción devuelta (Switch/Case)
            System.out.println(); // Separador para claridad
            switch (opcion) {
                case 1:
                    System.out.println(utilidades.centrarTexto("EJECUTANDO: Opción 1 (Procesos A)..."));
                    break;
                case 2:
                    System.out.println(utilidades.centrarTexto("EJECUTANDO: Opción 2 (Cálculos B)..."));
                    break;
                case 3:
                    System.out.println(utilidades.centrarTexto("EJECUTANDO: Opción 3 (Reportes C)..."));
                    break;
                case 4:
                    System.out.println(utilidades.centrarTexto("EJECUTANDO: Opción 4 (Configuración D)..."));
                    break;
                case 5:
                    System.out.println(utilidades.centrarTexto("EJECUTANDO: Opción 5 (Ayuda E)..."));
                    break;
                case 0:
                    // La salida se maneja después del switch
                    break;
            }
            if (opcion != 0) {
                System.out.println(utilidades.centrarTexto("...Presione ENTER para continuar al menú."));
                sc.nextLine(); // Espera una acción del usuario antes de volver al menú
                System.out.println("\n\n");
            }

        } while (opcion != 0);

        // 5. Finalización
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("¡Gracias por usar el programa! Saliendo..."));
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 6. Cerrar Scanner
        sc.close();
    }
}
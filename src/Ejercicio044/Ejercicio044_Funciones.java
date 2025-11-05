package Ejercicio044;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 044 | 2025-10-16
 */
public class Ejercicio044_Funciones {

    // CORRECCIÓN: Cambiar 'private' a 'public' para permitir el acceso desde Main
    public static final int OPCION_FINALIZAR = 6;

    /**
     * Muestra el submenú para una opción principal dada,
     * valida la entrada y gestiona el regreso.
     */
    public static void mostrarSubMenu(Scanner scanner, String titulo, String opcion1, String opcion2) {
        int opcionSub = 0;
        int opcionRegresar = 3;

        while (opcionSub != opcionRegresar) {
            System.out.println("\n--- SUBMENÚ: " + titulo + " ---");
            System.out.println("[1] " + opcion1);
            System.out.println("[2] " + opcion2);
            System.out.println("[" + opcionRegresar + "] Regresar al Menú Principal");
            System.out.print("> ");

            try {
                if (scanner.hasNextInt()) {
                    opcionSub = scanner.nextInt();
                    if (opcionSub == 1 || opcionSub == 2) {
                        System.out.println("\n*** Ejecutando Acción " + opcionSub + " de " + titulo + " ***");
                    } else if (opcionSub == opcionRegresar) {
                        System.out.println("\nRegresando...");
                    } else {
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                } else {
                    System.out.println("Error: Ingrese un número válido.");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }
    }

    /**
     * Muestra el menú principal, valida la entrada y devuelve la opción elegida.
     */
    public static int mostrarMenuPrincipal(Scanner scanner) {
        int opcionPrincipal = 0;

        while (opcionPrincipal < 1 || opcionPrincipal > OPCION_FINALIZAR) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("[1] Procesar Clientes");
            System.out.println("[2] Gestión de Inventario");
            System.out.println("[3] Reportes Financieros");
            System.out.println("[4] Configuración del Sistema");
            System.out.println("[5] Ayuda y Documentación");
            System.out.println("[" + OPCION_FINALIZAR + "] Finalizar Programa");
            System.out.print(">");

            try {
                if (scanner.hasNextInt()) {
                    opcionPrincipal = scanner.nextInt();

                    if (opcionPrincipal >= 1 && opcionPrincipal <= 5) {
                        // Llama al Submenú y se queda en el bucle principal (opcionPrincipal = 0)
                        switch (opcionPrincipal) {
                            case 1:
                                mostrarSubMenu(scanner, "Clientes", "Nuevo Cliente", "Buscar Cliente");
                                break;
                            case 2:
                                mostrarSubMenu(scanner, "Inventario", "Entrada de Producto", "Salida de Producto");
                                break;
                            case 3:
                                mostrarSubMenu(scanner, "Reportes", "Reporte de Ventas", "Reporte de Pérdidas");
                                break;
                            case 4:
                                mostrarSubMenu(scanner, "Configuración", "Cambiar Idioma", "Ajustar Fecha/Hora");
                                break;
                            case 5:
                                mostrarSubMenu(scanner, "Ayuda", "Ver Manual", "Soporte Técnico");
                                break;
                        }
                        // Reiniciar la opción para forzar a que el menú principal se muestre de nuevo
                        opcionPrincipal = 0;

                    } else if (opcionPrincipal == OPCION_FINALIZAR) {
                        // Opción de salida
                        return opcionPrincipal;

                    } else {
                        System.out.println("Opción no válida. Ingrese una opción entre 1 y " + OPCION_FINALIZAR + ".");
                    }
                } else {
                    System.out.println("Error: Ingrese un número entero válido.");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next();
            }
        }
        return OPCION_FINALIZAR;
    }
}
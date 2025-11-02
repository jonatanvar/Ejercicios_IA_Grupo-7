/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 088 | 2025-10-23               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Librerías;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static int contarMensajes(String[] arreglo) {
        int count = 0;
        for (String s : arreglo) if (s != null && !s.isEmpty()) count++;
        return count;
    }

    // Validaciones
    public static boolean validarMensaje(String mensaje) {
        return mensaje != null && !mensaje.trim().isEmpty();
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 088 | 2025-10-23                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }

    // Procesamiento de datos
    public static void cargarArchivoEnArreglo(String[] arreglo, String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null && i < arreglo.length) {
                String[] mensajes = linea.split("^^@^^");
                for (String msg : mensajes) {
                    if (msg.trim().length() > 0 && i < arreglo.length) {
                        arreglo[i++] = msg.trim();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public static void guardarMensajeEnArchivo(String mensaje, String nombreArchivo, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, append))) {
            if (!append) bw.write("");
            bw.write(mensaje + (append ? " ^^@^^ " : ""));
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    public static void mostrarMenu(Scanner scanner, String idioma) {
        String[] arreglo = new String[100];
        cargarArchivoEnArreglo(arreglo, "mensajes.txt");

        int opcion;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto(obtenerTexto("MENU_TITULO", idioma), ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│  a. " + obtenerTexto("OPCION_A", idioma) + " ".repeat(ANCHO - 20) + "│");
            System.out.println("│  b. " + obtenerTexto("OPCION_B", idioma) + " ".repeat(ANCHO - 20) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("a")) {
                    mostrarContenido(arreglo, idioma);
                } else if (input.equals("b")) {
                    agregarMensaje(scanner, arreglo, idioma);
                } else {
                    mostrarError("Opción inválida, intente de nuevo.", idioma);
                }
            }
        } while (continuar);
    }

    public static void mostrarContenido(String[] arreglo, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(obtenerTexto("CONTENIDO_TITULO", idioma), ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        int count = contarMensajes(arreglo);
        for (int i = 0; i < count && i < arreglo.length; i++) {
            System.out.println("│ " + (i + 1) + ". " + arreglo[i] + " ".repeat(ANCHO - 5 - arreglo[i].length()) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void agregarMensaje(Scanner scanner, String[] arreglo, String idioma) {
        System.out.print(obtenerTexto("INGRESE_MENSAJE", idioma));
        String mensaje = scanner.nextLine();
        if (validarMensaje(mensaje)) {
            guardarMensajeEnArchivo(mensaje, "mensajes.txt", true);
            cargarArchivoEnArreglo(arreglo, "mensajes.txt");
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto(obtenerTexto("MENSAJE_AGREGADO", idioma), ANCHO - 2) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
        } else {
            mostrarError("Mensaje inválido, intente de nuevo.", idioma);
        }
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);
        mostrarMenu(scanner, idiomaActual);
    }

    // Selección de idioma
    public static String seleccionarIdioma(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("SELECCIÓN DE IDIOMA / LANGUAGE SELECTION", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│  1. Español" + " ".repeat(ANCHO - 15) + "│");
            System.out.println("│  2. English" + " ".repeat(ANCHO - 15) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione su idioma / Select language: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                    String mensaje = "Idioma seleccionado / Selected language: " + (opcion == 1 ? "Español" : "English");
                    System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
                    System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                    return opcion == 1 ? "ES" : "EN";
                }
            } else {
                scanner.nextLine();
            }
            mostrarError("Opción inválida, intente de nuevo.", "ES");
        } while (true);
    }

    // Formato de salida
    public static void mostrarError(String mensaje, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // Procesamiento de textos
    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "MENU_TITULO": return "MENÚ DE MENSAJES";
                case "OPCION_A": return "Mostrar contenido del archivo";
                case "OPCION_B": return "Agregar mensaje";
                case "CONTENIDO_TITULO": return "CONTENIDO DEL ARCHIVO";
                case "INGRESE_MENSAJE": return "Ingrese un mensaje: ";
                case "MENSAJE_AGREGADO": return "Mensaje agregado exitosamente";
                default: return "";
            }
        } else {
            switch (clave) {
                case "MENU_TITULO": return "MESSAGE MENU";
                case "OPCION_A": return "Show file content";
                case "OPCION_B": return "Add message";
                case "CONTENIDO_TITULO": return "FILE CONTENT";
                case "INGRESE_MENSAJE": return "Enter a message: ";
                case "MENSAJE_AGREGADO": return "Message added successfully";
                default: return "";
            }
        }
    }
}
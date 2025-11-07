// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #84                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio084 | 2025-11-11

package Ejercicio084;

public class Ejercicio084_Operaciones {

    public static void seleccionarFigura() {
        String idioma = Ejercicio084_Menus.obtenerIdioma();
        int opcion;

        Ejercicio084_Utilidades.mostrarEncabezado(idioma.equals("ES") ? "SELECCIÓN DE FIGURA" : "FIGURE SELECTION");

        System.out.println(idioma.equals("ES") ? "1. Cuadrado borde vacío" : "1. Empty border square");
        System.out.println(idioma.equals("ES") ? "2. Cuadrado lleno" : "2. Filled square");
        System.out.println(idioma.equals("ES") ? "3. Cuadrado mitad lleno" : "3. Half-filled square");
        System.out.println(idioma.equals("ES") ? "4. Rectángulo vacío" : "4. Empty rectangle");
        System.out.println(idioma.equals("ES") ? "5. Rectángulo lleno" : "5. Filled rectangle");
        System.out.println(idioma.equals("ES") ? "6. Triángulo" : "6. Triangle");

        opcion = Ejercicio084_Utilidades.leerEntero(
                idioma.equals("ES") ? "Seleccione una opción: " : "Select an option: ", 1, 6
        );

        char c = Ejercicio084_Utilidades.leerCaracter(
                idioma.equals("ES") ? "Ingrese el carácter a usar: " : "Enter the character to use: "
        );

        switch (opcion) {
            case 1:
                int lado1 = Ejercicio084_Utilidades.leerEntero("Ingrese la longitud del lado: ", 1, 50);
                dibujarCuadradoVacio(lado1, c);
                break;
            case 2:
                int lado2 = Ejercicio084_Utilidades.leerEntero("Ingrese la longitud del lado: ", 1, 50);
                dibujarCuadradoLleno(lado2, c);
                break;
            case 3:
                int lado3 = Ejercicio084_Utilidades.leerEntero("Ingrese la longitud del lado: ", 1, 50);
                dibujarCuadradoMitadLleno(lado3, c);
                break;
            case 4:
                int largo4 = Ejercicio084_Utilidades.leerEntero("Ingrese lado largo: ", 1, 50);
                int corto4 = Ejercicio084_Utilidades.leerEntero("Ingrese lado corto: ", 1, 50);
                while (!validarLadosRectangulo(largo4, corto4)) {
                    System.out.println("El lado largo debe ser el doble del lado corto. Intente nuevamente.");
                    largo4 = Ejercicio084_Utilidades.leerEntero("Ingrese lado largo: ", 1, 50);
                    corto4 = Ejercicio084_Utilidades.leerEntero("Ingrese lado corto: ", 1, 50);
                }
                dibujarRectanguloVacio(largo4, corto4, c);
                break;
            case 5:
                int largo5 = Ejercicio084_Utilidades.leerEntero("Ingrese lado largo: ", 1, 50);
                int corto5 = Ejercicio084_Utilidades.leerEntero("Ingrese lado corto: ", 1, 50);
                while (!validarLadosRectangulo(largo5, corto5)) {
                    System.out.println("El lado largo debe ser el doble del lado corto. Intente nuevamente.");
                    largo5 = Ejercicio084_Utilidades.leerEntero("Ingrese lado largo: ", 1, 50);
                    corto5 = Ejercicio084_Utilidades.leerEntero("Ingrese lado corto: ", 1, 50);
                }
                dibujarRectanguloLleno(largo5, corto5, c);
                break;
            case 6:
                int altura = Ejercicio084_Utilidades.leerEntero("Ingrese la altura del triángulo: ", 1, 50);
                dibujarTriangulo(altura, c);
                break;
        }

        Ejercicio084_Utilidades.mostrarSelloCorto();
        Ejercicio084_Utilidades.mostrarPie(idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully.");
    }

    // ===== Funciones de dibujo =====
    public static void dibujarCuadradoVacio(int lado, char c) {
        for (int i = 1; i <= lado; i++) {
            for (int j = 1; j <= lado; j++) {
                if (i == 1 || i == lado || j == 1 || j == lado) System.out.print(c);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void dibujarCuadradoLleno(int lado, char c) {
        for (int i = 1; i <= lado; i++) {
            for (int j = 1; j <= lado; j++) System.out.print(c);
            System.out.println();
        }
    }

    public static void dibujarCuadradoMitadLleno(int lado, char c) {
        for (int i = 1; i <= lado; i++) {
            for (int j = 1; j <= lado; j++) {
                if (i <= lado / 2) System.out.print(c);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void dibujarRectanguloVacio(int largo, int corto, char c) {
        for (int i = 1; i <= corto; i++) {
            for (int j = 1; j <= largo; j++) {
                if (i == 1 || i == corto || j == 1 || j == largo) System.out.print(c);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void dibujarRectanguloLleno(int largo, int corto, char c) {
        for (int i = 1; i <= corto; i++) {
            for (int j = 1; j <= largo; j++) System.out.print(c);
            System.out.println();
        }
    }

    public static void dibujarTriangulo(int altura, char c) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) System.out.print(c);
            System.out.println();
        }
    }

    public static boolean validarLadosRectangulo(int largo, int corto) {
        return largo == 2 * corto;
    }
}
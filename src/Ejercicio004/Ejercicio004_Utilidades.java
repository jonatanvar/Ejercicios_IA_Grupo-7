package Ejercicio004;

/*
 * Cristina Cruz | Lis | cristinacruz@unah.hn | 004 | 2025-10-10
 */
import java.util.Scanner;

public class Ejercicio004_Utilidades {
    private static final String LINEA_SUP = "---------------------------------------------------------------------";
    private static final String LINEA_SEP = "|                                                                   |";
    private static final String LINEA_INF = "---------------------------------------------------------------------";
    private static final int ANCHO = 68;

    // Método para centrar texto dentro del ancho especificado
    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotales = ancho - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return "|" + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + "|";
    }

    // Método para mostrar el sello personalizado
    public static void mostrarSelloCorto(String codigoEjercicio, String fecha) {
        System.out.println(LINEA_SUP);
        System.out.println(centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println(LINEA_SEP);
        String sello = "Cristina Cruz | Lis | cristinacruz@unah.hn | " + codigoEjercicio + " | " + fecha;
        System.out.println(centrarTexto(sello, ANCHO));
        System.out.println(LINEA_INF);
        System.out.println();
    }

    // Método para leer un número del usuario
    public static double leerNumero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        double numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        return numero;
    }

    // Método para mostrar los resultados
    public static void mostrarResultados(double num1, double num2, double suma, double producto, double diferencia, double cociente) {
        System.out.println("\nResultados de las operaciones:");
        System.out.printf("Suma de %.2f y %.2f: %.2f\n", num1, num2, suma);
        System.out.printf("Producto de %.2f y %.2f: %.2f\n", num1, num2, producto);
        System.out.printf("Diferencia de %.2f y %.2f: %.2f\n", num1, num2, diferencia);
        if (num2 != 0) {
            System.out.printf("Cociente de %.2f y %.2f: %.2f\n", num1, num2, cociente);
        } else {
            System.out.println("Cociente: No se puede dividir por cero.");
        }
    }
}
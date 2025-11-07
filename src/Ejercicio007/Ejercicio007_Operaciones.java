// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos: Dany Noguera | dany.noguera@unah.hn | 007 | 2025-11-04          ║
// ║ Resumen: Funciones matemáticas puras (sin System.out).                     ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 007 | 2025-11-04

package Ejercicio007;

public class Ejercicio007_Operaciones {

    public static int suma(int a, int b, int c) {
        return a + b + c;
    }

    public static double promedio(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static int producto(int a, int b, int c) {
        return a * b * c;
    }

    public static int menor(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int mayor(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
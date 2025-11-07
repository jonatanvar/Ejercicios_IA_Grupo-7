// ╔════════════════════════════════════════════════════════════════════════════╗
// ║                          Metadatos del Desarrollador                       ║
// ║ Nombre: Dany Noguera                                                       ║
// ║ Correo: dany.noguera@unah.hn                                              ║
// ║ Fecha: 2025-11-04                                                         ║
// ║ Código: 002                                                                ║
// ║ Resumen: Utilidades gráficas reutilizables (centrado y separadores).      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 002 | 2025-11-04

package Ejercicio002_Dany_Noguera;

public class Ejercicio002_Utilidades {

    public static void centrarTexto(String texto, int ancho) {
        int espacios = (ancho - 2 - texto.length()) / 2;
        String izq = " ".repeat(Math.max(0, espacios));
        String der = " ".repeat(Math.max(0, ancho - 2 - texto.length() - espacios));
        System.out.println("║" + izq + texto + der + "║");
    }

    public static void mostrarSeparador(String titulo, int ancho) {
        System.out.println("╠" + "═".repeat(ancho - 2) + "╣");
        centrarTexto(titulo, ancho);
        System.out.println("╠" + "═".repeat(ancho - 2) + "╣");
    }
}
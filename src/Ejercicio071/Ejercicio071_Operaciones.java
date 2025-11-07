// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #71 — Torres de Hanoi                    ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio071 | 2025-11-07

package Ejercicio071;

public class Ejercicio071_Operaciones {

    public static void iniciarHanoi() {

        String idioma = Ejercicio071_Menus.obtenerIdioma();
        Ejercicio071_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TORRES DE HANOI" : "TOWERS OF HANOI"
        );

        int discos = 3;   // ← Valor fijo solicitado en el requerimiento

        System.out.println(idioma.equals("ES") ?
                "\nResolviendo para 3 discos...\n" :
                "\nSolving for 3 disks...\n"
        );

        // Llamada inicial: origen  → auxiliar → destino
        hanoi(discos, "Origen", "Auxiliar", "Destino");

        Ejercicio071_Utilidades.mostrarSelloCorto();
        Ejercicio071_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado." : "Process completed."
        );
    }

    /**
     * Función recursiva que resuelve las Torres de Hanoi
     */
    public static void hanoi(int n, String origen, String auxiliar, String destino) {

        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " → " + destino);
            return;
        }

        // Mover n-1 al auxiliar
        hanoi(n - 1, origen, destino, auxiliar);

        // Mover disco restante al destino
        System.out.println("Mover disco " + n + " de " + origen + " → " + destino);

        // Mover torre auxiliar hacia destino
        hanoi(n - 1, auxiliar, origen, destino);
    }
}